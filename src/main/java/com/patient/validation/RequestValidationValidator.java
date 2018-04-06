/*
 * RequestValidationValidator
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
package com.patient.validation;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.patient.model.PatientRequest;

public class RequestValidationValidator
		implements ConstraintValidator<RequestValidationConstraint, PatientRequest> {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestValidationValidator.class);

	public static final String INVALIDDATE = " date format is invalid";
	public static final String SCANDATE ="scanDate";
	public static final String DATEFORMAT ="dd-MMM-yyyy";
	
	public void initialize(final RequestValidationConstraint constraintAnnotation) {
		// Nothing to initialize
	}

	public boolean isValid(final PatientRequest serviceRequest, ConstraintValidatorContext context) {
		boolean flag = true;
		Class<PatientRequest> aClass = PatientRequest.class;
		try {
			if (!validateDate(serviceRequest, context, aClass)) {
				flag = false;
			}
		} catch (SecurityException e) {
			LOGGER.error(e.toString());
		} catch (IllegalArgumentException e) {
			LOGGER.error(e.toString());
		} catch (NoSuchFieldException e) {
			LOGGER.error(e.toString());
		}
		return flag;
	}

	private boolean validateDate(final PatientRequest serviceRequest,
			ConstraintValidatorContext context, Class<PatientRequest> aClass)
			throws NoSuchFieldException {
		boolean flag = true;
		String fieldValue = serviceRequest.getScanDate();
		Field field = aClass.getDeclaredField(SCANDATE);
		if (fieldValue != null && !dateTimePatternValidation(fieldValue)) {
			flag = false;
			context.disableDefaultConstraintViolation();
			
			context.buildConstraintViolationWithTemplate(INVALIDDATE)
					.addNode(field.getName()).addConstraintViolation();
		}
		return flag;
	}

	private static boolean dateTimePatternValidation(String dataTime) {
		boolean flag = true;
		SimpleDateFormat desiredFormat = new SimpleDateFormat(DATEFORMAT);
		try {
			desiredFormat.setLenient(false);
			desiredFormat.parse(dataTime);
		} catch (ParseException e) {
			flag = false;
		}
		return flag;
	}

}
