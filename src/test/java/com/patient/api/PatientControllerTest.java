/*
 * PCCalcTriggerController
 *
 * Copyright (c) 2018 Manulife International Ltd.
 *
 * Description:
 *
 *
 * Maintenance History
 *
 * YYMMDD Who              Reason
 * ====== ================ ====================================================
 * 180227 Cognizant       Application Development
 */
package com.patient.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patient.api.ExceptionHandlerAdvice;
import com.patient.api.PatientController;
import com.patient.model.PatientException;
import com.patient.model.PatientRequest;
import com.patient.model.PatientResponse;
import com.patient.service.PatientService;
import com.patient.test.helper.TestHelper;

/**
 * @author Cognizant
 *
 *         PcCalcTriggerApplication
 */
@RestController
public class PatientControllerTest {

	private static final String SERVICE_URL_PROPERTY_NAME = "app.service.url";

	private static final String SERVICE_URL = "/api/v1/triggerPcCalculation";

	private MockMvc mvc;

	@InjectMocks
	private PatientController pCCalcTriggerController;

	@Mock
	private PatientService mockPcTriggerService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(pCCalcTriggerController).setControllerAdvice(new ExceptionHandlerAdvice())
				.addPlaceholderValue(SERVICE_URL_PROPERTY_NAME, SERVICE_URL).build();
	}

	@Test
	public void testPCCalcTriggerController_Success() throws Exception {
		PatientRequest serviceRequest = TestHelper.getServiceRequest();
		PatientResponse serviceResponse = new PatientResponse();
		Mockito.when(mockPcTriggerService.performSubmittedPCCalculation(Mockito.any(PatientRequest.class)))
				.thenReturn(serviceResponse);
		String json = new ObjectMapper().writeValueAsString(serviceRequest);
		mvc.perform(post(SERVICE_URL).content(json).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		Mockito.reset(mockPcTriggerService);
	}

	@Test
	public void testPCCalcTriggerController_MethodArgumentNotValidException() throws Exception {
		PatientRequest serviceRequest = TestHelper.getServiceRequest();
		serviceRequest.setLob(null);
		String json = new ObjectMapper().writeValueAsString(serviceRequest);
		mvc.perform(post(SERVICE_URL).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testPCCalcTriggerController_ServiceException() throws Exception {
		PatientRequest serviceRequest = TestHelper.getServiceRequest();
		Mockito.when(mockPcTriggerService.performSubmittedPCCalculation(Mockito.any(PatientRequest.class)))
				.thenThrow(new PatientException("404",
						String.format("Proposal No %s Not Found", serviceRequest.getProposalNumber())));
		String json = new ObjectMapper().writeValueAsString(serviceRequest);
		mvc.perform(post(SERVICE_URL).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError());
		Mockito.reset(mockPcTriggerService);
	}

	@Test
	public void testPCCalcTriggerController_Exception() throws Exception {
		PatientRequest serviceRequest = TestHelper.getServiceRequest();
		Mockito.when(mockPcTriggerService.performSubmittedPCCalculation(Mockito.any(PatientRequest.class)))
				.thenThrow(new RuntimeException());
		String json = new ObjectMapper().writeValueAsString(serviceRequest);
		mvc.perform(post(SERVICE_URL).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError());
		Mockito.reset(mockPcTriggerService);
	}
}
