package com.employeeapi.base;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public static String empId = "21";
	
	public static Logger logger;
	
	@BeforeClass
	public void setUp() {
		 logger = Logger.getLogger(TestBase.class);
		logger.getLogger("employeeApi");
	}
	
}
