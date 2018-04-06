/*
 * Copyright (c) 2018 Manulife International Ltd.
 *
 * Description:
 * Interface for Service.
 *
 * Maintenance History
 *
 * YYMMDD Who              Reason
 * ====== ================ ====================================================
 *
 */
package com.patient.service;

import com.patient.model.PatientRequest;
import com.patient.model.PatientResponse;

public interface PatientService {

	PatientResponse performSubmittedPCCalculation(PatientRequest serviceRequest);

}
