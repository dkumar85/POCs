package com.harman.kafkaconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.harman.dto.CommandDto;

public class Sender {
	
	@Autowired
	  private KafkaTemplate<String, CommandDto> kafkaTemplate;

	  public void send(CommandDto command) {
		  System.out.println("\n Sending command!!");
	    kafkaTemplate.send("test1", command);
	  }

}
