package com.harman.dto;

import com.harman.Entity.CommandEntity;
import com.harman.Entity.WorkFlowEntity;

public class CommandReqeuestToTaskManagerDto {

	private String workFlowId;
	private String commandId;
	private String commandName;
	private String pluginId;
	private String userId;
	private String currentState;

	public CommandReqeuestToTaskManagerDto() {
		super();
	}
	
	
	public CommandReqeuestToTaskManagerDto(String workFlowId, String commandId, String commandName, String pluginId,
			String userId, String currentState) {
		super();
		this.workFlowId = workFlowId;
		this.commandId = commandId;
		this.commandName = commandName;
		this.pluginId = pluginId;
		this.userId = userId;
		this.currentState = currentState;
	}
	
	public CommandReqeuestToTaskManagerDto(WorkFlowEntity workFlowEntity, CommandEntity commandEntity) {
		
		this.workFlowId = workFlowEntity.getWorkFlowId();
		this.commandId = commandEntity.getCommandId();
		this.commandName = commandEntity.getCommandName();
		this.pluginId = commandEntity.getPluginId();
		this.userId = commandEntity.getUserId();
		this.currentState = commandEntity.getCurrentState();
	}
	
	
	public String getWorkFlowId() {
		return workFlowId;
	}
	public void setWorkFlowId(String workFlowId) {
		this.workFlowId = workFlowId;
	}
	public String getCommandId() {
		return commandId;
	}
	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public String getPluginId() {
		return pluginId;
	}
	public void setPluginId(String pluginId) {
		this.pluginId = pluginId;
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
	@Override
	public String toString() {
		return "CommandReqeuestToTaskManagerDto [workFlowId=" + workFlowId + ", commandId=" + commandId
				+ ", commandName=" + commandName + ", pluginId=" + pluginId + ", userId=" + userId + ", currentState="
				+ currentState + "]";
	}
	
	
	
	
}
