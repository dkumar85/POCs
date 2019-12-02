package com.harman.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.harman.entities.UserEntity;

public class MyUserDetails implements UserDetails{
	
	
	private String userName;
	private String passWord;
	private List<GrantedAuthority> authorities;
	private boolean active; 
	
	public MyUserDetails() {
	}
	
	public MyUserDetails(UserEntity user) {
		this.userName = user.getEmail();
		this.passWord = user.getPassword();
		this.active = user.isActive();
		/*this.authorities = Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
				*/
		
		authorities = new ArrayList<>();
		for (String role : user.getRoles())
		authorities.add(new SimpleGrantedAuthority(role));
		//authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return passWord;
	}

	@Override
	public String getUsername() {
		
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return active;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return active;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return active;
	}

	@Override
	public boolean isEnabled() {
		
		return active;
	}

}
