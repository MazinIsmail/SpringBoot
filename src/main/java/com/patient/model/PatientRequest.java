package com.patient.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.patient.validation.RequestValidationConstraint;

import io.swagger.annotations.ApiModelProperty;

@RequestValidationConstraint
public class PatientRequest {

	private static final String EMPTYMESSAGE = " is missing";
	private static final String INVALIDLENGTHMESSAGE = "exceeds the maximum lenth";
	private static final String INVALIDDATAMESSAGE = "invalid Data";

	@ApiModelProperty(notes = "Policy Number")
	@NotEmpty(message = EMPTYMESSAGE)
	@Size(max = 10, message = INVALIDLENGTHMESSAGE)
	private String policyNumber;
	@ApiModelProperty(notes = "Proposal Number")
	@NotEmpty(message = EMPTYMESSAGE)
	@Size(max = 20, message = INVALIDLENGTHMESSAGE)
	private String proposalNumber;
	@ApiModelProperty(notes = "Scan Date (dd-MMM-yyyy)")
	@NotEmpty(message = EMPTYMESSAGE)
	private String scanDate;
	@ApiModelProperty(notes = "Business Category (IFPNB)")
	@NotEmpty(message = EMPTYMESSAGE)
	@Pattern(regexp = "(?)IFPNB", message = INVALIDDATAMESSAGE)
	private String businessCategory;
	@ApiModelProperty(notes = "Submission Type (NB)")
	@NotEmpty(message = EMPTYMESSAGE)
	@Pattern(regexp = "(?)NB", message = INVALIDDATAMESSAGE)
	private String submitType;
	@ApiModelProperty(notes = "LOB (IND)")
	@NotEmpty(message = EMPTYMESSAGE)
	@Pattern(regexp = "(?)IND", message = INVALIDDATAMESSAGE)
	private String lob;
	@ApiModelProperty(notes = "System Code (CAS)")
	@NotEmpty(message = EMPTYMESSAGE)
	@Pattern(regexp = "(?)CAS", message = INVALIDDATAMESSAGE)
	private String sysCode;

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getProposalNumber() {
		return proposalNumber;
	}

	public void setProposalNumber(String proposalNumber) {
		this.proposalNumber = proposalNumber;
	}

	public String getScanDate() {
		return scanDate;
	}

	public void setScanDate(String scanDate) {
		this.scanDate = scanDate;
	}

	public String getBusinessCategory() {
		return businessCategory;
	}

	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceRequest [policyNumber=").append(policyNumber).append(", proposalNumber=")
				.append(proposalNumber).append(", scanDate=").append(scanDate).append(", businessCategory=")
				.append(businessCategory).append(", submitType=").append(submitType).append(", lob=").append(lob)
				.append(", sysCode=").append(sysCode).append("]");
		return builder.toString();
	}

}
