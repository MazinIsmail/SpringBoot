package com.patient.service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.patient.config.ApplicationConfig;
import com.patient.model.PatientException;
import com.patient.model.PatientRequest;
import com.patient.model.PatientResponse;
import com.patient.util.Constants;
import com.patient.util.RestErrorUtil;

@Component
public class PatientRestHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(PatientRestHandler.class);

	@Autowired
	@Qualifier("ifpPcCalculatorServiceRestTemplate")
	private RestTemplate ifpPcCalculatorServiceRestTemplate;

	@Autowired
	ApplicationConfig applicationConfig;

	public PatientResponse invokePcCalcRestService(PatientRequest serviceRequest) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> requestMap = new HashMap<>();
		requestMap.put(Constants.PROP_INP_POLNO, serviceRequest.getPolicyNumber());
		requestMap.put(Constants.PROP_INP_PROPNO, serviceRequest.getProposalNumber());
		requestMap.put(Constants.PROP_INP_SCANDT, serviceRequest.getScanDate());
		String jsonInput = null;
		try {
			jsonInput = mapper.writeValueAsString(requestMap);
		} catch (IOException e1) {
			throw new PatientException(Constants.INTERNAL_SERVER_ERRORCODE, e1.getMessage());
		}
		LOGGER.debug("Invoke {} with input as {}", applicationConfig.getIfpPcCalculatorServiceRestURL(), jsonInput);
		HttpEntity<?> request = new HttpEntity<>(jsonInput, headers);
		ResponseEntity<String> calculationResponse = ifpPcCalculatorServiceRestTemplate.exchange(
				applicationConfig.getIfpPcCalculatorServiceRestURL(), HttpMethod.POST, request,
				String.class);
		HttpStatus httpRetStatus = calculationResponse.getStatusCode();
		PatientResponse serviceResponse = null;
		try {
			serviceResponse = mapper.readValue(calculationResponse.getBody(), PatientResponse.class);
		} catch (IOException e) {
			throw new PatientException(Constants.INTERNAL_SERVER_ERRORCODE, e.getMessage());
		}
		if(RestErrorUtil.isError(httpRetStatus)) {
			throw new PatientException(serviceResponse.getReturnCode(),serviceResponse.getReturnMessage());
		}
		return serviceResponse;
	}

}
