package com.harman.dto;

public class AuthenticationResponseDto {
	
	private final String jwtToken;
	private final int expiresIn;
	private final String refreshToken;
	
	public AuthenticationResponseDto(String jwtToken, int expiresIn, String refreshToken) {
		super();
		this.jwtToken = jwtToken;
		this.expiresIn = expiresIn;
		this.refreshToken = refreshToken;
	}


	public int getExpiresIn() {
		return expiresIn;
	}


	public String getJwtToken() {
		return jwtToken;
	}


	public String getRefreshToken() {
		return refreshToken;
	}
	
	
}
