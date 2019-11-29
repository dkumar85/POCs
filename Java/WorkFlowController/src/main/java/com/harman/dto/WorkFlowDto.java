package com.harman.dto;

import java.util.ArrayList;


/**
 * This class will be used to get details of the workflow to be saved in database. 
 * @author Dharam 
 *
 */

public class WorkFlowDto {


	private String workflowName;
	private String workflowId;
	private String userId;
	private ArrayList<CommandDto> commandDtoList = new ArrayList<CommandDto>();
	
	public WorkFlowDto() {
	}
	
	public WorkFlowDto(String workflowName, String workflowId, String userId) {
		super();
		this.workflowName = workflowName;
		this.workflowId = workflowId;
		this.userId = userId;
	}
	
	public WorkFlowDto(String workflowName, String workflowId, String userId, ArrayList<CommandDto> commandDtoList) {
		super();
		this.workflowName = workflowName;
		this.workflowId = workflowId;
		this.userId = userId;
		this.commandDtoList = commandDtoList;
	}

	
	public String getWorkflowName() {
		return workflowName;
	}
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	public String getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	public ArrayList<CommandDto> getCommandDtoList() {
		return commandDtoList;
	}

	public void setCommandDtoList(ArrayList<CommandDto> commandDtoList) {
		this.commandDtoList = commandDtoList;
	}

	@Override
	public String toString() {
		return "WorkFlowDto [workflowName=" + workflowName + ", workflowId=" + workflowId + ", userId=" + userId
				+ ", commandDtoList=" + commandDtoList + "]";
	}

}
