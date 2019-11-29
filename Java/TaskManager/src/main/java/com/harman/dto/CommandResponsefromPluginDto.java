package com.harman.dto;

import com.fasterxml.jackson.annotation.JsonInclude;



/**
 * This class defines the response sent by plugin simulator.
 * 
 *  Various command states can be:
 *  EXECUTION_NOT_STARTED, ACCEPTED, PENDING, EXECUTING, FAILED, FINISHED 
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public class CommandResponsefromPluginDto {


	private String workFlowId;
	private String commandId;
	private String commandName;
	private String pluginId;
	private String userId;
	private String currentState;
	
	public CommandResponsefromPluginDto() {

	}
	
	public CommandResponsefromPluginDto(CommandRequestToPluginDto commandRequestDto) {
		
		this.workFlowId = commandRequestDto.getWorkFlowId();
		this.commandId = commandRequestDto.getCommandId();
		this.commandName = commandRequestDto.getCommandName();
		this.pluginId = commandRequestDto.getPluginId();
		this.userId	= commandRequestDto.getUserId();
		this.currentState = commandRequestDto.getCurrentState();

	}
	
	public CommandResponsefromPluginDto(String workFlowId, String commandId, String commandName, String pluginId, String userId,
			String currentState) {
		super();
		this.workFlowId = workFlowId;
		this.commandId = commandId;
		this.commandName = commandName;
		this.pluginId = pluginId;
		this.userId = userId;
		this.currentState = currentState;
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
		return "CommandResponseDto [workFlowId=" + workFlowId + ", commandId=" + commandId + ", commandName="
				+ commandName + ", pluginId=" + pluginId + ", userId=" + userId + ", currentState=" + currentState
				+ "]";
	}
}
