package com.harman.udfcontrollers;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harman.configuration.PluginProperties;
import com.harman.dto.CommandDto;
import com.harman.dto.ResponseDto;
import com.harman.kafkaconfiguration.Sender;
import com.harman.service.CommandService;
import com.harman.service.PluginConfigurationService;


@RestController
@RequestMapping("/udf")
public class CommandController {
	
	private static Logger logger = LogManager.getLogger();
	
	
	/*
	 * @Autowired ProducerService producerService;
	 */
	
	@Autowired
	Sender sender;	
	
	@Autowired
	CommandService commandService;
	
	@Autowired
	PluginConfigurationService pluginConfigurationService; 
	
	
	/*
	 * @RequestMapping("/publish") public void sendMessageToKafkaTopic (){
	 * this.producerService.sendMessage("Message from Producer"); }
	 */
	
	@PostMapping("/publish")
	public void sendMessageToKafkaTopic(@Valid @RequestBody CommandDto command, @RequestHeader ("userId") Long userId ) {
	
		logger.info("Inside the execute command controller");
		sender.send(command);
	}
	
	
	 @RequestMapping("/test")
	    public String test() {
	        System.out.println("test");
	        return "test";
	    }
	 
	 @RequestMapping("/pluginconfiguration")
	    public  String printPluginConfiguration() {
		 pluginConfigurationService.printPluginConfiguration();
		 return "Propeties printed to the console";
	    }
	 
	@PostMapping("/executecommand")
	public ResponseEntity<ResponseDto> executeCommand(@Valid @RequestBody CommandDto command, @RequestHeader ("userId") Long userId ) {
	
		logger.info("Inside the execute command controller");
		return commandService.executeCommand(command);
		
	}
}
