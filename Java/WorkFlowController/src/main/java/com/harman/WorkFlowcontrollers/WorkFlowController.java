package com.harman.WorkFlowcontrollers;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harman.dto.CommandDto;
import com.harman.dto.ResponseDto;
import com.harman.dto.WorkFlowDto;
import com.harman.dto.WorkFlowToExecuteDto;
import com.harman.service.WorkFlowService;

@RestController
@RequestMapping("/workflow")
public class WorkFlowController {
	private static Logger logger = LogManager.getLogger();
	
	@Autowired
	WorkFlowService workFlowService;
	
	 @RequestMapping("/test")
	    public String test() {
	        System.out.println("test");
	        return "test";
	    }
	
	 @PostMapping(value="/save", consumes = "application/json", produces = "application/json")
		public  ResponseEntity<ResponseDto> saveWorkFlow(@Valid @RequestBody WorkFlowDto workFlowDto, @RequestHeader ("userId") Long userId ) {
		
			return workFlowService.saveWorkFlow(workFlowDto);
		}
	 
	 @PostMapping(value="/execute", consumes = "application/json")
		public void executeWorkFlow(@Valid @RequestBody WorkFlowToExecuteDto workFlowToExecuteDto, @RequestHeader ("userId") Long userId ) {
		
			workFlowService.executeWorkFlow(workFlowToExecuteDto);
		}
	 
	 @PostMapping(value="/getdetails")
		public ResponseEntity<ResponseDto> getWorkFlowDetails(@Valid @RequestBody WorkFlowToExecuteDto workFlowToExecuteDto) {
		
			return workFlowService.getWorkFlowDetails(workFlowToExecuteDto);
		}

}
