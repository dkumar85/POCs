package com.harman.configurations;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;



@Configuration
//@PropertySource("classpath:custom.properties")
@ConfigurationProperties (prefix = "custom")
public class CustomProperties {
	
	private int jwtexpiryinsec;
	private int refreshTokenexpiryinsec;

	public CustomProperties() {
		super();
	}
	
	public CustomProperties(int jwtexpiryinsec, int refreshTokenexpiryinsec) {
		super();
		this.jwtexpiryinsec = jwtexpiryinsec;
		this.refreshTokenexpiryinsec = refreshTokenexpiryinsec;
	}

	public int getJwtexpiryinsec() {
		return jwtexpiryinsec;
	}
	
	public void setJwtexpiryinsec(int jwtexpiryinsec) {
		this.jwtexpiryinsec = jwtexpiryinsec;
	}
	public int getRefreshTokenexpiryinsec() {
		return refreshTokenexpiryinsec;
	}

	public void setRefreshTokenexpiryinsec(int refreshTokenexpiryinsec) {
		this.refreshTokenexpiryinsec = refreshTokenexpiryinsec;
	}

	

	

}
