package com.harman.controllers;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harman.dto.ResponseDto;
import com.harman.dto.SignUpDto;
import com.harman.services.SignupService;

@RestController
@CrossOrigin
@RequestMapping("/autodep")
public class SignupController {
	
	private static Logger logger = LogManager.getLogger();
	
	
	@RequestMapping("/test")
    public String test() {
        System.out.println("test");
        return "test";
    }
	
	@Autowired
	SignupService signupService;
	
	@PostMapping("/signup")
	public ResponseEntity<ResponseDto> signUp(@Valid @RequestBody SignUpDto signUpDto) {
		
		return signupService.executeCommand(signUpDto);
		
	}


}
