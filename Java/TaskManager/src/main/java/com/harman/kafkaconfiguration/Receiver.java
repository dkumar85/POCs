package com.harman.kafkaconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import com.harman.dto.CommandRequestFromWorkFlowControllerDto;
import com.harman.service.ExecuteCommandService;

public class Receiver {


	@Autowired
	ExecuteCommandService executeCommandService;
	
	@KafkaListener(topics = "test1", clientIdPrefix = "first")
	public void receive3(CommandRequestFromWorkFlowControllerDto commandRequestFromWorkFlowControllerDto) {   				// this type is to be changed to CommanEntity
		//System.out.println("\n received3 command='{}'"+ commandRequestFromWorkFlowControllerDto.toString());
		executeCommandService.sendCommandToPlugin(commandRequestFromWorkFlowControllerDto);
	  
		/*
		 * try { Thread.sleep(4000); } catch(InterruptedException ex) {
		 * Thread.currentThread().interrupt(); }
		 */
	  }
	 
	    
}

