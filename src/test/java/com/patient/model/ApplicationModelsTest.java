package com.patient.model;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.patient.model.ProductionCredit;
import com.patient.model.PatientRequest;
import com.patient.model.PatientResponse;

import pl.pojo.tester.api.assertion.Method;

@RunWith(SpringRunner.class)
public class ApplicationModelsTest {

	@Test
	public void testServiceRequest() {
		final Class<?> classUnderTest = PatientRequest.class;
		assertPojoMethodsFor(classUnderTest).testing(Method.CONSTRUCTOR)
				.testing(Method.GETTER, Method.SETTER, Method.TO_STRING).areWellImplemented();
	}

	@Test
	public void testServiceResponse() {
		final Class<?> classUnderTest = PatientResponse.class;
		assertPojoMethodsFor(classUnderTest).testing(Method.CONSTRUCTOR)
				.testing(Method.GETTER, Method.SETTER, Method.TO_STRING).areWellImplemented();
	}

	@Test
	public void testProductionCredit() {
		final Class<?> classUnderTest = ProductionCredit.class;
		assertPojoMethodsFor(classUnderTest).testing(Method.CONSTRUCTOR)
				.testing(Method.GETTER, Method.SETTER, Method.TO_STRING).areWellImplemented();
	}

}
