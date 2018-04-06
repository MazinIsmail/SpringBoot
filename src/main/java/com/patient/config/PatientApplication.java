/*
 * PcCalcTriggerApplication
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
package com.patient.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Cognizant
 *
 *         PcCalcTriggerApplication
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.manulife.*")
public class PatientApplication {
	/**
	 * Main method to start spring boot application
	 */
	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);
	}
}
