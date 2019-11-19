package com.harman.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.harman.dto.CommandDto;
import com.harman.dto.ResponseDto;
import com.harman.entity.CommandEntity;
import com.harman.repositories.CommandRepository;

@Service
public class CommandService {
	
	private static Logger logger = LogManager.getLogger();
	
	@Autowired
	CommandRepository commandRepository;
	
	public ResponseEntity<ResponseDto> executeCommand(CommandDto command){
	
		ResponseEntity<ResponseDto> responseEntity = null;
		ResponseDto response = new ResponseDto();
		
		
		logger.info("Inside the executeCommand() method");
		
	
		//send command to the plugin for execution. Note: This code be written later using mocking framework.
		//if plugin sends back ok for the command save command parametes in mongo db
		
		//send command details to cron for getting the status. This code will be written using mockito framework.
		
		CommandEntity commandEntity = new CommandEntity(command);
		commandEntity.setCurrentState("Started");
		commandRepository.save(commandEntity);
		//response.setData(data); //setting no data as just acknowlegement is to be sent
	
		response.setData(commandEntity);
		response.setCode(HttpStatus.OK);
		response.setMessage("Command executed successfully");
		response.setMessageCode("200");
		
		responseEntity = new ResponseEntity<ResponseDto>(response, response.getCode());
		return responseEntity;
	}

}
