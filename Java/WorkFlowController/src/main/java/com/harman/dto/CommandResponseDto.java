package com.harman.dto;



public class CommandResponseDto {


	private String commandName;
	private String pluginId;
	private String userId;
	private String commandState;
	
	public CommandResponseDto() {
	}	
	
	public CommandResponseDto(String commandName, String pluginId, String userId, String commandState) {
		super();
		this.commandName = commandName;
		this.pluginId = pluginId;
		this.userId = userId;
		this.commandState = commandState;
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
	public String getCommandState() {
		return commandState;
	}
	public void setCommandState(String commandState) {
		this.commandState = commandState;
	}
	@Override
	public String toString() {
		return "CommandResponseDto [commandName=" + commandName + ", pluginId=" + pluginId + ", userId=" + userId
				+ ", commandState=" + commandState + "]";
	}

}
