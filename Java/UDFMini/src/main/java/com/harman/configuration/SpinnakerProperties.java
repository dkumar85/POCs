package com.harman.configuration;

public class SpinnakerProperties {


	private String url;
	private String mode;
	
	public SpinnakerProperties() {
		super();
	}
	
	public SpinnakerProperties(String url, String mode) {
		super();
		this.url = url;
		this.mode = mode;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getMode() {
		return mode;
	}
	
	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return "SpinnakerProperties [url=" + url + ", mode=" + mode + "]";
	}
	
}
