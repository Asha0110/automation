package com.employeeapi.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utils.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_Post_Employee_Record extends TestBase {
	RequestSpecification httpRequest;

	String empname = RestUtils.empName();
	String empSalary = RestUtils.empSal();
	String empAge = RestUtils.empAge();

	@BeforeClass
	public void createEmployee() {

		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();

		// JSONObject is a class that represents a simple JSON. we can add key value
		// pairs using put method
		JSONObject requestparam = new JSONObject();
		requestparam.put("name", empname);
		requestparam.put("salary", empSalary);
		requestparam.put("age", empAge);

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestparam.toJSONString());
		response = httpRequest.request(Method.POST, "/create");

	}

	@Test
	public void checkStatusCode() {

		int statuscode = response.getStatusCode(); // getting status code
		logger.info("status code:" + statuscode);
		Assert.assertEquals(statuscode, 200);
	}

	@Test
	public void checkresponseBody() {
		String responseBody = response.getBody().asString();
		logger.info("response body:" + responseBody);
		Assert.assertTrue(responseBody != null);

	}

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
