package com.harman.kafkaconfiguration;

import java.util.concurrent.TimeUnit;

import org.springframework.kafka.annotation.KafkaListener;

import com.harman.dto.CommandDto;

public class Receiver {

	
	  @KafkaListener(topics = "test1", clientIdPrefix = "first") 
	  public void receive1(CommandDto command) {
	  System.out.println("\n received1 command='{}'"+ command.toString());
	  
		/*
		 * try { Thread.sleep(4000); } catch(InterruptedException ex) {
		 * Thread.currentThread().interrupt(); }
		 */
	  }
	 
	
	  @KafkaListener(topics = "test1", clientIdPrefix = "second")
	  public void receive2(CommandDto command) {
	    System.out.println("\n received2 command='{}'"+ command.toString());
		/*
		 * try { Thread.sleep(2000); } catch(InterruptedException ex) {
		 * Thread.currentThread().interrupt(); }
		 */
	  }
	    
}

