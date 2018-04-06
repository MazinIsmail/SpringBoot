package com.patient.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

public class PatientResponse {

	@ApiModelProperty(notes = "Response Code")
	private String returnCode;
	@ApiModelProperty(notes = "Response Message")
	private String returnMessage;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@ApiModelProperty(notes = "Production Credit Data (All Agents)")
	private List<ProductionCredit> pcList;

	public PatientResponse() {
		super();
	}
	public PatientResponse(String returnCode, String returnMessage) {
		super();
		this.returnCode = returnCode;
		this.returnMessage = returnMessage;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	public List<ProductionCredit> getPcList() {
		return pcList;
	}

	public void setPcList(List<ProductionCredit> pcList) {
		this.pcList = pcList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CalculationResponse [returnCode=").append(returnCode).append(", returnMessage=")
				.append(returnMessage).append(", pcList=").append(pcList).append("]");
		return builder.toString();
	}

}
