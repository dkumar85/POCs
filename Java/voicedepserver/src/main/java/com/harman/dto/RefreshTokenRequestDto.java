package com.harman.dto;

import javax.validation.constraints.NotNull;

public class RefreshTokenRequestDto {
	
	@NotNull
	private String refreshToken;
	
	public RefreshTokenRequestDto( ) {
		
	}
	
	public RefreshTokenRequestDto(String refreshToken) {
		super();
		this.refreshToken = refreshToken;
	}
	
	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	
	

}
