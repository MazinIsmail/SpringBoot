package com.patient.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.patient.util.RestResponseErrorHandler;

@Configuration
public class ApplicationConfig {

	@Value("${rest.connectionRequestTimeout}")
	private Integer connectionRequestTimeout;

	@Value("${rest.connectTimeout}")
	private Integer connectTimeout;

	@Value("${rest.readTimeout}")
	private Integer readTimeout;

	@Value("${rest.service.ifpPcCalculatorServiceRestURL}")
	private String ifpPcCalculatorServiceRestURL;

	public ApplicationConfig() {
		super();
	}

	public Integer getConnectionRequestTimeout() {
		return connectionRequestTimeout;
	}

	public Integer getConnectTimeout() {
		return connectTimeout;
	}

	public Integer getReadTimeout() {
		return readTimeout;
	}

	public String getIfpPcCalculatorServiceRestURL() {
		return ifpPcCalculatorServiceRestURL;
	}

	@Bean
	@Qualifier("ifpPcCalculatorServiceRestTemplate")
	public RestTemplate ifpPcCalculatorServiceRestTemplate() {
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setConnectionRequestTimeout(getConnectionRequestTimeout());
		httpRequestFactory.setConnectTimeout(getConnectTimeout());
		httpRequestFactory.setReadTimeout(getReadTimeout());
		RestTemplate rt = new RestTemplate(httpRequestFactory);
		rt.setErrorHandler(new RestResponseErrorHandler("ifpPcCalculatorService"));
		return rt;
	}

}
