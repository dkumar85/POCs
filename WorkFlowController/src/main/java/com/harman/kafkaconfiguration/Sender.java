package com.harman.kafkaconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.harman.dto.CommandReqeuestToTaskManagerDto;

public class Sender {
	
	@Autowired
	  private KafkaTemplate<String, CommandReqeuestToTaskManagerDto> kafkaTemplate;

	  public void send(CommandReqeuestToTaskManagerDto commandReqeuestToTaskManagerDto) {
		  System.out.println("\n Sending command!!");
	    kafkaTemplate.send("test1", commandReqeuestToTaskManagerDto);
	  }

}
