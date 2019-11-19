package com.harman.services;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.harman.dto.ResponseDto;
import com.harman.dto.SignUpDto;
import com.harman.entities.UserEntity;
import com.harman.repositories.UserRepository;

@Service
public class SignupService {

	private static Logger logger = LogManager.getLogger();
	
	@Autowired
	UserRepository userRepository;
	
	public ResponseEntity<ResponseDto> executeCommand(SignUpDto signUpDto){
		
		logger.info("Inside the executeCommand() method");
		
		ResponseEntity<ResponseDto> responseEntity = null;
		ResponseDto response = new ResponseDto();
		
		Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(signUpDto.getEmail());
		if(optionalUserEntity.isPresent()) {
			logger.info("User already exists in database. Cannot proceed with registration");
			
			response.setData(null);
			response.setCode(HttpStatus.CONFLICT);
			response.setMessage("Registration failed! User already exists.");
			response.setMessageCode("409");
			
			responseEntity = new ResponseEntity<ResponseDto>(response, response.getCode());
			return responseEntity;
		} else {
			
			UserEntity userEntity = new UserEntity(signUpDto);
			userRepository.save(userEntity);
			
		
			response.setData(userEntity);
			response.setCode(HttpStatus.OK);
			response.setMessage("Congratulations! User registered successfully.");
			response.setMessageCode("200");
			
			responseEntity = new ResponseEntity<ResponseDto>(response, response.getCode());
			return responseEntity;
			}
		
	}

}
