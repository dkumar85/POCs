package com.harman.WorkFlowcontrollers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.harman.dto.CommandDto;
import com.harman.dto.Greeting;
import com.harman.dto.HelloMessage;


@Controller
public class WebSocketController {
	
	
	  @MessageMapping("/hello")
	  
	  @SendTo("/topic/greetings") 
	      public Greeting greeting (HelloMessage message){ 
		  //Thread.sleep(1000);
		  CommandDto command = new CommandDto();
		  command.setCommandName("temp Comman");
		  command.setPluginId("1");
		  command.setUserId("1");
		  return new Greeting(command.toString());
		  }
	 
	
	
	/*
	 * @MessageMapping("/hello")
	 * 
	 * @SendTo("/topic/greetings") public CommandDto sendCommandToBrowser
	 * (HelloMessage message)throws Exception{ Thread.sleep(1000); CommandDto
	 * command = new CommandDto(); command.setcommandName("temp Comman");
	 * command.setPluginId("1"); command.setUserId("1"); return command; }
	 */
}
