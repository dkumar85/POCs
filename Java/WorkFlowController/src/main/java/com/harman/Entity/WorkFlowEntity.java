package com.harman.Entity;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.harman.dto.CommandDto;
import com.harman.dto.WorkFlowDto;

@Document(collection="WorkFlowDetails")
public class WorkFlowEntity {
	
	@Id
	private String id;
	
	private String workFlowName;
	private String workFlowId;
	private String userId;
	private String currentState;
	private ArrayList<CommandEntity> commandList = new ArrayList<CommandEntity>();
	
	public WorkFlowEntity() {
	
	}
	
	public WorkFlowEntity(WorkFlowDto workFlowDto) {
		this.workFlowName = workFlowDto.getWorkflowName();
		this.workFlowId = workFlowDto.getWorkflowId();
		this.userId = workFlowDto.getUserId();
		this.currentState = "EXECUTION_NOT_STARTED";
		for (CommandDto commandDto : workFlowDto.getCommandDtoList()) {
			CommandEntity commandEntity = new CommandEntity(commandDto);
			this.commandList.add(commandEntity);
		}
	}
	
	public WorkFlowEntity(String id, String workFlowName, String workFlowId, String userId, String currentState, 
			ArrayList<CommandEntity> commandList) {
		super();
		this.id = id;
		this.workFlowName = workFlowName;
		this.workFlowId = workFlowId;
		this.userId = userId;
		this.currentState = currentState;
		this.commandList = commandList;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWorkFlowName() {
		return workFlowName;
	}
	public void setWorkFlowName(String workFlowName) {
		this.workFlowName = workFlowName;
	}
	public String getWorkFlowId() {
		return workFlowId;
	}
	public void setWorkFlowId(String workFlowId) {
		this.workFlowId = workFlowId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCurrentState() {
		return currentState;
	}
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	public ArrayList<CommandEntity> getCommandList() {
		return commandList;
	}
	public void setCommandList(ArrayList<CommandEntity> commandList) {
		this.commandList = commandList;
	}
	@Override
	public String toString() {
		return "WorkFlowEntity [id=" + id + ", workFlowName=" + workFlowName + ", workFlowId=" + workFlowId
				+ ", userId=" + userId + ", currentState=" + currentState + ", commandList=" + commandList + "]";
	}
	
}
