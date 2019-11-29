package com.harman.controllers;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.harman.dto.CommandRequestDto;
import com.harman.dto.CommandResponseDto;
import com.harman.dto.ResponseDto;

@RestController
@RequestMapping("/command")
public class PluginController {
	
	private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/execute")
	public ResponseEntity<ResponseDto> executeCommand(@Valid @RequestBody CommandRequestDto commandRequest) {
	
		logger.info("Inside the execute command controller");
		
		
		CommandResponseDto commandResponseDto = new CommandResponseDto(commandRequest);
		
		switch (commandRequest.getCurrentState()) {
		case "EXECUTION_NOT_STARTED":
			commandResponseDto.setCurrentState("ACCEPTED");
			break;
		case "ACCEPTED":
			commandResponseDto.setCurrentState("PENDING");
			break;
		case "PENDING":
			commandResponseDto.setCurrentState("EXECUTING");
			break;
		case "EXECUTING":
			commandResponseDto.setCurrentState("FINISHED");
			break;
		default:
			commandResponseDto.setCurrentState("FAILED");
		}
		
		ResponseDto response = new ResponseDto();
		response.setData(commandResponseDto);
		response.setCode(HttpStatus.OK);
		response.setMessage("Command executed successfully");
		response.setMessageCode("200");
		ResponseEntity<ResponseDto> responseEntity = new ResponseEntity<ResponseDto>(response, response.getCode());
		return responseEntity;	
		//switch case code
	}

}
