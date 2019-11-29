package com.harman.hello;

/*
 * This is the object that server will return to the browser.
 */

public class Greeting {

	private String content;
	
	public Greeting() {
	}
	
	public Greeting(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
