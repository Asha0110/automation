package com.employeeapi.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_Get_All_Employees extends TestBase {

	@BeforeClass
	public void getAllEmployees() throws InterruptedException {
	logger.info("***starting getting all employee method");
		
	RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
	httpRequest = RestAssured.given();
	response = httpRequest.request(Method.GET,"/employees");
	Thread.sleep(3000);
	}
	
	@Test
	 public void checkresponseBody() {
		String responseBody = response.getBody().asString();
	logger.info("response body:" + responseBody);
	Assert.assertTrue(responseBody!=null);
	
	}
	
	@Test
	public void checkStatusCode() {
	
	int statuscode = response.getStatusCode(); // getting status code
	logger.info("status code:" + statuscode);
	Assert.assertEquals(statuscode, 200);
	}
	
	@Test
	public void checkStatusLine() {
		String statusline = response.getStatusLine();
		logger.info("****status line:" + statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}
	
	@Test
	public void checkContentType() {
		String contentType = response.header("Content-Type");
		
		logger.info("content type:" + contentType);
		Assert.assertEquals(contentType,"application/json" );
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
		 logger.info("contentencoding:" + contentencoding );
		 Assert.assertEquals(contentencoding, "gzip");
	}
	
	@Test
	public void checkcontentLength() {
		 String contentlength = response.header("Content-Length");
		 logger.info("contentencoding:" + contentlength );
		if(Integer.parseInt(contentlength)<100) {
			logger.warn("Content length is less than 100");
			
			Assert.assertTrue(Integer.parseInt(contentlength)>100);
		}
	}
		 
		@Test
		 public void checkCookies() {
		String cookie = response.getCookie("PHPSESSID");
		}
		 
		
	@AfterClass
	
	public void tearDown() {
		logger.info("***finished TC001_Get_All_Employees***");
	}
		
	
	 
	
	
}
