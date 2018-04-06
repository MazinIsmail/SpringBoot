package com.patient.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.patient.model.PatientRequest;
import com.patient.model.PatientResponse;
import com.patient.service.PatientRestHandler;
import com.patient.test.helper.TestHelper;
import com.patient.test.helper.TestPcCalcTriggerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { TestPcCalcTriggerApplication.class })
public class PatientRestHandlerTest {

	@Autowired
	private PatientRestHandler pcCalcRestHandler;

	@Test
	public void testPcCalcRestHandler() {
		PatientRequest serviceRequest = TestHelper.getServiceRequest();
		PatientResponse serviceResponse = pcCalcRestHandler.invokePcCalcRestService(serviceRequest);
		assertEquals(serviceResponse.getReturnMessage(), "Success");
	}

}
