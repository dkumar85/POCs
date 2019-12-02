package com.harman.controllers;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.harman.common.utils.JwtUtil;
import com.harman.common.utils.MyBCryptPasswordEncoder;
import com.harman.configurations.CustomProperties;
import com.harman.dto.AuthenticationRequestDto;
import com.harman.dto.AuthenticationResponseDto;
import com.harman.dto.RefreshTokenRequestDto;
import com.harman.dto.ResponseDto;
import com.harman.dto.SignUpDto;
import com.harman.entities.UserEntity;
import com.harman.repositories.UserRepository;
import com.harman.services.MyUserDetailsService;
import com.harman.services.Security;
import com.harman.services.SignupService;

@RestController
@CrossOrigin(origins="*")
public class SignupController {
	
	private static Logger logger = LogManager.getLogger();
	
	@Autowired
	SignupService signupService;
	
	@Autowired
	Security security;
	
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody AuthenticationRequestDto authenticationRequest) throws Exception {
		
		return security.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		
	}
	
	@PostMapping("/refreshtoken")
	public ResponseEntity<?> refreshToken(@Valid @RequestBody RefreshTokenRequestDto refreshTokenRequestDto) throws Exception{
		
		return security.refreshToken(refreshTokenRequestDto.getRefreshToken());
		
	}
	
	
	@PostMapping("/signup")
	public ResponseEntity<ResponseDto> signUp(@Valid @RequestBody SignUpDto signUpDto) {
		
		return signupService.executeCommand(signUpDto);
		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")	
	@RequestMapping("/test")
    public String test() {
        System.out.println("test");
        return "test";
    }

	@GetMapping("/user")
	public String user() {
		return "<h1> Welcome User </h1>";
	}
	
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1> Welcome admin. </h1>";
	}
	
	


}
