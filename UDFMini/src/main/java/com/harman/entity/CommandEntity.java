package com.harman.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.harman.dto.CommandDto;

@Document(collection="CommandsUnderExecution")
public class CommandEntity {
	
	@Id
	public String id;
	
	public String commandName;
	public String pluginId;
	public String userId;
	public String currentState;
	
	public CommandEntity() {
		super();
	}
	
	public CommandEntity(CommandDto command) {
		super();
		this.commandName = command.getcommandName();
		this.pluginId = command.getPluginId();
		this.userId = command.getUserId();
	}
	
	public CommandEntity(String id, String commandName, String pluginId, String userId, String currentState) {
		super();
		this.id = id;
		this.commandName = commandName;
		this.pluginId = pluginId;
		this.userId = userId;
		this.currentState = currentState;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		return "CommandEntitiy [id=" + id + ", commandName=" + commandName + ", pluginId=" + pluginId + ", userId="
				+ userId + ", currentState=" + currentState + "]";
	}

}
