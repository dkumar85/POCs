package com.harman.dto;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ResponseDto {

	HttpStatus code; //response code
	String messageCode; // Message code
	String message; //Response message
	Object data;	//Additional data
	
	public ResponseDto() {
		
	}	
	
	public ResponseDto(String message) {
		super();
		this.message = message;
	}
	
	public ResponseDto(HttpStatus code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public ResponseDto(HttpStatus code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public ResponseDto(HttpStatus code, String message, String messageCode) {
		super();
		this.code = code;
		this.message = message;
		this.messageCode = messageCode;
	}
	
	public ResponseDto(HttpStatus code, String messageCode, String message, Object data) {
		super();
		this.code = code;
		this.messageCode = messageCode;
		this.message = message;
		this.data = data;
	}
	
	public ResponseDto(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
