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

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.patient.model.PatientException;
import com.patient.model.PatientRequest;
import com.patient.model.PatientResponse;
import com.patient.service.PatientService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Cognizant
 *
 *         PcCalcTriggerApplication
 */
@RestController
public class PatientController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	PatientService pcCalcFacadeService;

	/**
	 * Method to calculate the submitted PC by invoking the dependent services.
	 *
	 * @throws PatientException
	 */
	@RequestMapping(value = "${app.service.url}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Calculate Submitted PC")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = PatientResponse.class),
			@ApiResponse(code = 200, message = "Commission Configuration / Version / Rate Error", response = PatientResponse.class),
			@ApiResponse(code = 400, message = "Required parameter is not valid", response = PatientResponse.class),
			@ApiResponse(code = 404, message = "Proposal / Policy Not Found", response = PatientResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = PatientResponse.class) })
	public ResponseEntity<PatientResponse> calculateSubmittedPC(@Valid @RequestBody PatientRequest request) {
		PatientResponse serviceResponse = pcCalcFacadeService.performSubmittedPCCalculation(request);
		LOGGER.debug("Service Response for Request {} is {}", request, serviceResponse);
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
}
