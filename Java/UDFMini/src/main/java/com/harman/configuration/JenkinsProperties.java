package com.harman.configuration;

public class JenkinsProperties {
	

	private String url;
	private int pollingInterval;
	
	public JenkinsProperties() {
		super();
	}
	
	public JenkinsProperties(String url, int pollingInterval) {
		super();
		this.url = url;
		this.pollingInterval = pollingInterval;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPollingInterval() {
		return pollingInterval;
	}
	public void setPollingInterval(int pollingInterval) {
		this.pollingInterval = pollingInterval;
	}

	@Override
	public String toString() {
		return "JenkinsProperties [url=" + url + ", pollingInterval=" + pollingInterval + "]";
	}

}
