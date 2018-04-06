package com.patient.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class RestResponseErrorHandler implements ResponseErrorHandler {
	private static final Logger log = LoggerFactory.getLogger(RestResponseErrorHandler.class);
	private String serviceName;

	public RestResponseErrorHandler() {
		super();
	}

	public RestResponseErrorHandler( String serviceName) {
		 this.serviceName =  serviceName;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		log.error("Error in {}: {} {}", serviceName, response.getStatusCode(), response.getStatusText());
	}

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return RestErrorUtil.isError(response.getStatusCode());
	}

}
