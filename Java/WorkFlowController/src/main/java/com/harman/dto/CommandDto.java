package com.harman.dto;


public class CommandDto {

	private String commandId;
	private String commandName;
	private String pluginId;
	private String userId;
	private String currentState;
	
	public CommandDto() {
		super();
	}
	
	public CommandDto(String commandId, String commandName, String pluginId, String userId, String currentState) {
		super();
		this.commandId = commandId;
		this.commandName = commandName;
		this.pluginId = pluginId;
		this.userId = userId;
		this.currentState = currentState;
	}
	

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public String getCommandId() {
		return commandId;
	}

	public void setCommandId(String commandId) {
		this.commandId = commandId;
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
		return "CommandDto [commandId=" + commandId + ", commandName=" + commandName + ", pluginId=" + pluginId
				+ ", userId=" + userId + ", currentState=" + currentState + "]";
	}
	

	
}
