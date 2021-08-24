package com.employeeapi.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_Delete_Employee_Record extends TestBase{

	RequestSpecification httprequest;
	Response response;
	@BeforeClass
	 public void deleteEmployee() throws InterruptedException {
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		 httprequest = RestAssured.given();
		response =  httprequest.request(Method.GET,"/employees");
		
		
		// first get the jsonPath object instance from the response
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		// capture id
		String empId = jsonPathEvaluator.get("[0].id");
	response = httprequest.request(Method.DELETE,"/delete/"+empId);
		Thread.sleep(3000);
	}
	
	@Test
	public void checkStatusCode() {

		int statuscode = response.getStatusCode(); // getting status code
		logger.info("status code:" + statuscode);
		Assert.assertEquals(statuscode, 200);
	}
	
	
//	@Test
//	public void checkresponseBody() {
//		String responseBody = response.getBody().asString();
//	logger.info("*****responseBody*******");
//	Assert.assertEquals(responseBody.contains("successfully!deleted records"), true);;
//	}
	
	@Test
	public void checkContentType() {
		String contenttype = response.header("Content-type");
		logger.info("***** contenttype *****");
		Assert.assertEquals(contenttype, "application/json");
	}

	@AfterClass

	public void tearDown() {
		logger.info("***finished TC002_Get_Single_Employees_Record***");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
