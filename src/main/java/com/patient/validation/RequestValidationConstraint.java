/*
 * RequestValidationConstraint
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
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = RequestValidationValidator.class)
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestValidationConstraint {
	String message() default "Invalid Request";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}