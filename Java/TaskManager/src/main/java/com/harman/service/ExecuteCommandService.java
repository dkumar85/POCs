package com.harman.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.harman.dto.CommandRequestToPluginDto;
import com.harman.dto.CommandRequestFromWorkFlowControllerDto;
import com.harman.dto.ResponseDto;


@Service
public class ExecuteCommandService {
	
	private static Logger logger = LogManager.getLogger();
	
	public void sendCommandToPlugin(CommandRequestFromWorkFlowControllerDto commandRequestFromWorkFlowControllerDto) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		CommandRequestToPluginDto commandRequestToPluginDto = new CommandRequestToPluginDto(commandRequestFromWorkFlowControllerDto);
		
		logger.info("Calling plugin rest end point to execut the command with following request payload.");
		logger.info(commandRequestFromWorkFlowControllerDto.toString());
		
		ResponseEntity<ResponseDto> responseEntity = restTemplate.postForEntity("http://localhost:9001/command/execute",commandRequestToPluginDto, ResponseDto.class);
		
		logger.info("\n Following response was received from Plugin:");
		logger.info(responseEntity.getBody().getData().toString()+"\n");
		
	}

}
