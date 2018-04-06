package com.patient.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.patient.model.PatientRequest;
import com.patient.model.PatientResponse;
import com.patient.service.PatientRestHandler;
import com.patient.service.PatientService;
import com.patient.service.PatientServiceImpl;
import com.patient.test.helper.TestHelper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { PatientServiceImpl.class })
public class PatientServiceTest {

	@Autowired
	private PatientService pcTriggerService;

	@MockBean
	private PatientRestHandler mockPcCalcRestHandler;

	@Test
	public void testPcTriggerService() {
		PatientRequest serviceRequest = TestHelper.getServiceRequest();
		PatientResponse serviceResponse = new PatientResponse();
		Mockito.when(mockPcCalcRestHandler.invokePcCalcRestService(Mockito.any(PatientRequest.class)))
				.thenReturn(serviceResponse);
		pcTriggerService.performSubmittedPCCalculation(serviceRequest);
		Mockito.verify(mockPcCalcRestHandler, VerificationModeFactory.times(1)).invokePcCalcRestService(serviceRequest);
		Mockito.reset(mockPcCalcRestHandler);
	}

}
