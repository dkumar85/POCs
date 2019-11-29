package com.harman.Entity;


import org.springframework.data.annotation.Id;

import com.harman.dto.CommandDto;

public class CommandEntity {
	
	private String commandName;
	private String commandId;
	private String pluginId;
	private String userId;
	private String currentState;
	
	public CommandEntity() {
		super();
	}
	
	public CommandEntity(CommandDto command) {
		super();
		this.commandId = command.getCommandId();
		this.commandName = command.getCommandName();
		this.pluginId = command.getPluginId();
		this.userId = command.getUserId();
		this.currentState = command.getCurrentState();
	}
	
	public CommandEntity(String id, String commandName, String commandId, String pluginId, String userId,
			String currentState) {
		super();
		this.commandName = commandName;
		this.commandId = commandId;
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
	
	public String getCommandId() {
		return commandId;
	}

	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}

	@Override
	public String toString() {
		return "CommandEntity [ commandName=" + commandName + ", commandId=" + commandId + ", pluginId="
				+ pluginId + ", userId=" + userId + ", currentState=" + currentState + "]";
	}

}
