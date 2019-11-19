package com.harman.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.harman.Entity.CommandEntity;
import com.harman.Entity.WorkFlowEntity;
import com.harman.dto.CommandReqeuestToTaskManagerDto;
import com.harman.dto.ResponseDto;
import com.harman.dto.WorkFlowDto;
import com.harman.dto.WorkFlowToExecuteDto;
import com.harman.kafkaconfiguration.Sender;
import com.harman.repositories.WorkFlowRepository;

@Service
public class WorkFlowService {
private static Logger logger = LogManager.getLogger();
	
	@Autowired
	WorkFlowRepository workFlowRepository; 
	
	@Autowired
	Sender sender;
	
	public ResponseEntity<ResponseDto> saveWorkFlow(WorkFlowDto workFlowDto){
		
		logger.info("Inside the saveWorkFlow() method");
		
		try {
			WorkFlowEntity workFlowEntity = new WorkFlowEntity(workFlowDto);
			workFlowRepository.save(workFlowEntity);
			
			ResponseDto response = new ResponseDto();
			response.setData(workFlowEntity);
			response.setCode(HttpStatus.OK);
			response.setMessage("Command executed successfully");
			response.setMessageCode("200");
			ResponseEntity<ResponseDto> responseEntity  = new ResponseEntity<ResponseDto>(response, response.getCode());
			return responseEntity;
		} catch (Exception e) {
			logger.error("\n Error occured while saving the workflow:.....\n"+e);
			
			ResponseDto response = new ResponseDto();
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("Error occured while saving the workflow");
			response.setMessageCode("500");
			ResponseEntity<ResponseDto> responseEntity  = new ResponseEntity<ResponseDto>(response, response.getCode());
			return responseEntity;
		}
		
	}
	
	public void executeWorkFlow(WorkFlowToExecuteDto workFlowToExecuteDto){
		
		logger.info("Inside the executeWorkFlow() method");
		
		try {
			Optional<WorkFlowEntity> optionalWorkFlowEntity = workFlowRepository.findByworkFlowId(workFlowToExecuteDto.getWorkFlowId());
			if(optionalWorkFlowEntity.isPresent()) {
				logger.info("Workflow found in DB. Now going to execute each command in workflow.");
				
				WorkFlowEntity workFlowEntity = optionalWorkFlowEntity.get();
				if(workFlowEntity.getCommandList().size()>0) {
					// fetching each command from the workflow object and sending it to the TaskManager
					for (CommandEntity command : workFlowEntity.getCommandList()) {
						CommandReqeuestToTaskManagerDto commandReqeuestToTaskManagerDto = new CommandReqeuestToTaskManagerDto(workFlowEntity, command );
						sender.send(commandReqeuestToTaskManagerDto);
					}
				} else {
					
				logger.info("This workflow does not have any command.");
				}
			
				
			} else {
				
				logger.info("No workflow with this ID found in DB.");
			}

		} catch (Exception e) {
			logger.error("\n Error occured while saving the workflow:.....\n"+e);
			
		}
		
	}
	
	public ResponseEntity<ResponseDto>  getWorkFlowDetails(WorkFlowToExecuteDto workFlowToExecuteDto){
		
		logger.info("Inside the getWorkFlowDetails() method");
		
		try {
			Optional<WorkFlowEntity> optionalWorkFlowEntity = workFlowRepository.findByworkFlowId(workFlowToExecuteDto.getWorkFlowId());
			if(optionalWorkFlowEntity.isPresent()) {
				logger.info("Workflow found in DB.");
				
				WorkFlowEntity workFlowEntity = optionalWorkFlowEntity.get();
				
				ResponseDto response = new ResponseDto();
				response.setData(workFlowEntity);
				response.setCode(HttpStatus.OK);
				response.setMessage("Command executed successfully");
				response.setMessageCode("200");
				ResponseEntity<ResponseDto> responseEntity  = new ResponseEntity<ResponseDto>(response, response.getCode());
				return responseEntity;
				
			} else {
				logger.error("\n Workflow was not found in the DB......\n");
				ResponseDto response = new ResponseDto();
				response.setCode(HttpStatus.OK);
				response.setMessage("Workflow was not found in the DB.");
				response.setMessageCode("200");
				ResponseEntity<ResponseDto> responseEntity  = new ResponseEntity<ResponseDto>(response, response.getCode());
				return responseEntity;
			}

		} catch (Exception e) {
			logger.error("\n Error occured while getting workflow details.:.....\n"+e);
			ResponseDto response = new ResponseDto();
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("Error occured while saving the workflow");
			response.setMessageCode("500");
			ResponseEntity<ResponseDto> responseEntity  = new ResponseEntity<ResponseDto>(response, response.getCode());
			return responseEntity;
			
		}
		
	}

}
