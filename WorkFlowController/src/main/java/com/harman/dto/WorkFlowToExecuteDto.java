package com.harman.dto;


/**
 * This class will be used get details of the workflow to be executed.
 * @author indkumar01
 *
 */
public class WorkFlowToExecuteDto {


	private String workFlowName;
	private String workFlowId;
	private String userId;
	
	public WorkFlowToExecuteDto() {
		
	}
	
	public WorkFlowToExecuteDto(String workFlowName, String workFlowId, String userId) {
		super();
		this.workFlowName = workFlowName;
		this.workFlowId = workFlowId;
		this.userId = userId;
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
}
