package com.harman.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class CommandDto {

	
	public String commandName;
	public String pluginId;
	public String userId;
	
	public CommandDto() {
		super();
	}
	
	public CommandDto(String commandName, String pluginId, String userId) {
		super();
		this.commandName = commandName;
		this.pluginId = pluginId;
		this.userId = userId;
	}

	public String getcommandName() {
		return commandName;
	}

	public void setcommandName(String commandName) {
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

	@Override
	public String toString() {
		return "CommandDto [commandName=" + commandName + ", pluginId=" + pluginId + ", userId=" + userId + "]";
	}
}
