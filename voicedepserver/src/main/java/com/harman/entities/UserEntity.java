package com.harman.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.harman.dto.SignUpDto;

@Document (collection="UserInfo")
public class UserEntity {
	
	@Id
	private String id;
	private String email;
	private String password;
	private String question;
	private String answer;
	private boolean rememberMe;
	
	public UserEntity() {
		super();
	}
	
	public UserEntity(SignUpDto signUpDto) {
		super();
		this.email = signUpDto.getEmail();
		this.password = signUpDto.getPassword();
		this.question = signUpDto.getQuestion();
		this.answer = signUpDto.getAnswer();
	}
	
	public UserEntity(String id, String email, String password, String question, String answer, boolean rememberMe) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.question = question;
		this.answer = answer;
		this.rememberMe = rememberMe;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", email=" + email + ", password=" + password + ", question=" + question
				+ ", answer=" + answer + ", rememberMe=" + rememberMe + "]";
	}
	
}
