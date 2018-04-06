/*
 * Copyright (c) 2018 Manulife International Ltd.
 *
 * Description:
 * Service class.
 *
 * Maintenance History
 *
 * YYMMDD Who              Reason
 * ====== ================ ====================================================
 *
 */
package com.patient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.model.PatientRequest;
import com.patient.model.PatientResponse;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRestHandler pcCalcRestHandler;

	/*
	 * Form PcCalcFacadeServiceResponse and return.
	 */
	@Override
	public PatientResponse performSubmittedPCCalculation(PatientRequest serviceRequest) {
		return pcCalcRestHandler.invokePcCalcRestService(serviceRequest);
	}

}
