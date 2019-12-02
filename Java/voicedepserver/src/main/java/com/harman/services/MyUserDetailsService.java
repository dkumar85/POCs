package com.harman.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.harman.entities.UserEntity;
import com.harman.pojo.MyUserDetails;
import com.harman.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> user = userRepository.findByEmail(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: "+username));
		return user.map(MyUserDetails::new).get();
	}
	
	public UserDetails loadUserByRefreshToken(String refreshToken) throws UsernameNotFoundException {
		Optional<UserEntity> user = userRepository.findByRefreshToken(refreshToken);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: "+refreshToken));
		return user.map(MyUserDetails::new).get();
	}

}
