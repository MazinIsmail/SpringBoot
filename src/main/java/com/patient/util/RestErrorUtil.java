/*
 * Copyright (c) 2018 Manulife International Ltd.
 *
 * Description:
 * Rest error util class.
 *
 * Maintenance History
 *
 * YYMMDD Who              Reason
 * ====== ================ ====================================================
 *
 */
package com.patient.util;

import org.springframework.http.HttpStatus;

public class RestErrorUtil {

	private RestErrorUtil() {
		super();
	}

	public static boolean isError(HttpStatus status) {
		HttpStatus.Series series = status.series();
		return (HttpStatus.Series.CLIENT_ERROR.equals(series) || HttpStatus.Series.SERVER_ERROR.equals(series));
	}
}
