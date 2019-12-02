package com.harman.services;

import java.util.Date;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.harman.common.utils.JwtUtil;
import com.harman.common.utils.MyBCryptPasswordEncoder;
import com.harman.configurations.CustomProperties;
import com.harman.dto.AuthenticationResponseDto;
import com.harman.dto.RefreshTokenResponseDto;
import com.harman.entities.UserEntity;
import com.harman.repositories.UserRepository;

@Service
public class Security {
	private static Logger logger = LogManager.getLogger();
	
	@Autowired
	SignupService signupService;	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired 
	private MyBCryptPasswordEncoder myBCryptPasswordEncoder;
	
	@Autowired
	CustomProperties customProperties;
	
	@Autowired
	UserRepository userRepository;

	
	@Autowired
	private JwtUtil jwtUtil;
	
	public ResponseEntity<?> authenticate(String username, String password) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
		
		final String jwtToken = jwtUtil.generateToken(userDetails);
		final String refreshToken = myBCryptPasswordEncoder.encode(userDetails.getUsername()+System.currentTimeMillis());
		
		Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(username);
		UserEntity user = optionalUserEntity.get(); //control will come here only when user is valid
		user.setRefreshToken(refreshToken);
		user.setrefreshTokenExpiryDate(new Date(System.currentTimeMillis()+ (customProperties.getRefreshTokenexpiryinsec() * 1000)));
		userRepository.save(user);
		
		return ResponseEntity.ok(new AuthenticationResponseDto(jwtToken,customProperties.getJwtexpiryinsec(),refreshToken));
	}
	
	
	public ResponseEntity<?> refreshToken(String refreshToken) throws Exception{
		
		Optional<UserEntity> optionalUserEntity = userRepository.findByRefreshToken(refreshToken);
		
		if (optionalUserEntity.isPresent()) {
			UserEntity user = optionalUserEntity.get();
			if (user.getrefreshTokenExpiryDate().before(new Date())) {
				throw new Exception("Refresh token has expired.");
			} else {
				final UserDetails userDetails = myUserDetailsService.loadUserByRefreshToken(refreshToken);
				final String jwtToken = jwtUtil.generateToken(userDetails);	
				return ResponseEntity.ok(new RefreshTokenResponseDto(jwtToken,customProperties.getJwtexpiryinsec()));
			}
			
		} else {
			throw new Exception("Invalid refresh token.");
		}
		
		
			
	}
}
