package com.harman.dto;

public class RefreshTokenResponseDto {
	private final String jwtToken;
	private final int expiresIn;
	
	public RefreshTokenResponseDto(String jwtToken, int expiresIn) {
		super();
		this.jwtToken = jwtToken;
		this.expiresIn = expiresIn;
	}
	
	public String getJwtToken() {
		return jwtToken;
	}
	
	public int getExpiresIn() {
		return expiresIn;
	}
}
