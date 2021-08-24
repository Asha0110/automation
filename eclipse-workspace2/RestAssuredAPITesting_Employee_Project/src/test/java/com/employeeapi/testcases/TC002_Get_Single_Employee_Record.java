package com.employeeapi.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_Get_Single_Employee_Record extends TestBase {

	@BeforeClass

	public void getEmployeeData() throws InterruptedException {
		logger.info("***started TC002_Get_single_Employee_Record***");
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employee/" + empId);
		Thread.sleep(3000);
	}

	@Test
	public void checkResponseBody() {
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(empId), true);

	}

	@Test
	public void checkStatusCode() {
		int statuscode = response.getStatusCode();
		logger.info("***** statuscode *****");
		Assert.assertEquals(statuscode, 200);
	}

	@Test
	public void checkContentType() {
		String contenttype = response.header("Content-type");
		logger.info("***** contenttype *****");
		Assert.assertEquals(contenttype, "application/json");
	}

	@Test
	public void checkResponseTime() {
		long time = response.getTime();
		logger.info("***** time *****");
		Assert.assertTrue(time < 2000);
	}

	@Test
	public void checkserverType() {
		String servertype = response.header("Server");
		logger.info("serverType:" + servertype);
		Assert.assertEquals(servertype, "cloudflare");

	}

	@Test
	public void checkcontentEncoding() {
		String contentencoding = response.header("Content-Encoding");
		logger.info("contentencoding:" + contentencoding);
		Assert.assertEquals(contentencoding, "gzip");
	}

	@AfterClass

	public void tearDown() {
		logger.info("***finished TC002_Get_Single_Employees_Record***");
	}

}
