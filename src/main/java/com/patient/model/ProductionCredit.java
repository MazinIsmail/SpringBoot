package com.patient.model;

import io.swagger.annotations.ApiModelProperty;

public class ProductionCredit {

	@ApiModelProperty(notes = "Agent Code")
	private String agentCode;
	@ApiModelProperty(notes = "Submitted PC")
	private Long submittedPc;
	@ApiModelProperty(notes = "Submitted APE")
	private Double submittedApe;
	@ApiModelProperty(notes = "Submitted Case Count")
	private Integer submittedCaseCount;
	@ApiModelProperty(notes = "Plan Code")
	private String planCode;
	@ApiModelProperty(notes = "Is Basic Plan")
	private String basicPlan;
	@ApiModelProperty(notes = "Plan VersNum")
	private String planVersNum;

	public ProductionCredit() {
		super();
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public Long getSubmittedPc() {
		return submittedPc;
	}

	public void setSubmittedPc(Long submittedPc) {
		this.submittedPc = submittedPc;
	}

	public Double getSubmittedApe() {
		return submittedApe;
	}

	public void setSubmittedApe(Double submittedApe) {
		this.submittedApe = submittedApe;
	}

	public Integer getSubmittedCaseCount() {
		return submittedCaseCount;
	}

	public void setSubmittedCaseCount(Integer submittedCaseCount) {
		this.submittedCaseCount = submittedCaseCount;
	}

	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public String getBasicPlan() {
		return basicPlan;
	}

	public void setBasicPlan(String basicPlan) {
		this.basicPlan = basicPlan;
	}

	public String getPlanVersNum() {
		return planVersNum;
	}

	public void setPlanVersNum(String planVersNum) {
		this.planVersNum = planVersNum;
	}

	@Override
	public String toString() {
		return "ProductionCredit [agentCode=" + agentCode + ", submittedPc=" + submittedPc + ", submittedApe="
				+ submittedApe + ", submittedCaseCount=" + submittedCaseCount + ", planCode=" + planCode
				+ ", basicPlan=" + basicPlan + ", planVersNum=" + planVersNum + "]";
	}

}
