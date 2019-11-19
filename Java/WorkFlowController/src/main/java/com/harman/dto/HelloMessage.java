package com.harman.dto;

/*
 * This is the json object that will be sent by
 * browser to the server.
 */

public class HelloMessage {
	


	private String name;

	public HelloMessage() {
	}
	
	public HelloMessage(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
