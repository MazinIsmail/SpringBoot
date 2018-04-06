package com.patient.model;

public class PatientException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String code;
	private String message;

	public PatientException() {
		super();
	}

	public PatientException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ServiceException [code=" + code + ", message=" + message + "]";
	}

}
