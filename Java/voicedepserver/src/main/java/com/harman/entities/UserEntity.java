package com.harman.entities;

import java.util.ArrayList;
import java.util.Date;

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
	private boolean active;
	private ArrayList<String> roles;
	private String refreshToken;
	private Date refreshTokenExpiryDate;

	public UserEntity(SignUpDto signUpDto) {
		super();
		this.email = signUpDto.getEmail();
		this.password = signUpDto.getPassword();
		this.question = signUpDto.getQuestion();
		this.answer = signUpDto.getAnswer();
		this.active = true;
		this.roles = new ArrayList<>();
		this.roles.add("ROLE_USER");
		
	}
	
	public UserEntity(String id, String email, String password, String question, String answer, 
			boolean rememberMe, boolean active, ArrayList<String> roles) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.question = question;
		this.answer = answer;
		this.rememberMe = rememberMe;
		this.active = active;
		this.roles = roles;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ArrayList<String> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<String> roles) {
		this.roles = roles;
	}

	public UserEntity() {
		super();
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
	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Date getrefreshTokenExpiryDate() {
		return refreshTokenExpiryDate;
	}

	public void setrefreshTokenExpiryDate(Date refreshTokenExpiryDate) {
		this.refreshTokenExpiryDate = refreshTokenExpiryDate;
	}
	
}
