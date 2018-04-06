/*
 * SwaggerConfig
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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("production-credit")
        		.apiInfo(apiInfo())
        		.select()
        		.apis(RequestHandlerSelectors.basePackage("com.manulife.submitpc.pctrigger.api"))
        		.paths(PathSelectors.any())
        		.build()
        		.useDefaultResponseMessages(false);
    }

	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
	        .title("Production Credit Calculator - IFPNB - Traditional-Basic")
	        .description("API to calculate production credit for Agents")
	        .contact(new Contact("HKIT-SOA-CoE","","hksoacoe@manulife.com"))
	        .version("1.0.0")
	        .build();
    }
}
