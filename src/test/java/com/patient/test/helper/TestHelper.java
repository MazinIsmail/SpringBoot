package com.patient.test.helper;

import java.util.ArrayList;
import java.util.List;

import com.patient.model.ProductionCredit;
import com.patient.model.PatientRequest;
import com.patient.model.PatientResponse;

public class TestHelper {

	public static PatientRequest getServiceRequest() {
		PatientRequest serviceRequest = new PatientRequest();
		serviceRequest.setBusinessCategory("IFPNB");
		serviceRequest.setLob("IND");
		serviceRequest.setPolicyNumber("ASDASDASD");
		serviceRequest.setProposalNumber("AA8T6R2183J39G44");
		serviceRequest.setScanDate("13-MAR-2018");
		serviceRequest.setSubmitType("NB");
		serviceRequest.setSysCode("CAS");
		return serviceRequest;
	}

	public static PatientResponse getServiceResponse() {
		PatientResponse serviceResponse = new PatientResponse();
		List<ProductionCredit> productionCreditList = new ArrayList<>();
		ProductionCredit productionCredit = new ProductionCredit();
		productionCredit.setAgentCode("317836");
		productionCredit.setBasicPlan("Y");
		productionCredit.setPlanCode("HH599");
		productionCredit.setPlanVersNum("01");
		productionCredit.setSubmittedApe(3993.6);
		productionCredit.setSubmittedCaseCount(1);
		productionCredit.setSubmittedPc((long) 998);
		productionCreditList.add(productionCredit);
		serviceResponse.setPcList(productionCreditList);
		serviceResponse.setReturnCode("RESP-001");
		serviceResponse.setReturnMessage("Success");
		return serviceResponse;
	}
}
