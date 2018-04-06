/*
 * ExceptionHandlerAdvice
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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.patient.model.PatientException;
import com.patient.model.PatientResponse;
import com.patient.util.Constants;

/**
 * Exception handling Rest Controller Advice.
 *
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

	/**
	 * Method to handle unknown exception
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> unknownException(Exception ex) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(ex.toString());
		if (ex.getCause() != null) {
			strBuilder.append(ex.getCause().toString());
		}
		String exceptionStackTrace = strBuilder.toString();
		if (LOGGER.isErrorEnabled()) {
			LOGGER.error(exceptionStackTrace);
		}
		PatientResponse response = new PatientResponse();
		response.setReturnCode(Constants.INTERNAL_SERVER_ERRORCODE);
		response.setReturnMessage(ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(PatientException.class)
	public ResponseEntity<Object> serviceException(PatientException ex) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(ex.toString());
		if (LOGGER.isErrorEnabled()) {
			LOGGER.error(strBuilder.toString());
		}
		PatientResponse response = new PatientResponse();
		response.setReturnCode(ex.getCode());
		response.setReturnMessage(ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Method to handle method argument not valid exception
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		PatientResponse response = new PatientResponse();
		StringBuilder errorMessage = new StringBuilder();
		String prefix = "";
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			errorMessage.append(prefix);
			prefix = ",";
			errorMessage.append(fieldError.getField()).append(" ").append(fieldError.getDefaultMessage());
		}
		response.setReturnCode(Constants.VALIDATION_RES_CODE);
		response.setReturnMessage(errorMessage.toString());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

	}

}
