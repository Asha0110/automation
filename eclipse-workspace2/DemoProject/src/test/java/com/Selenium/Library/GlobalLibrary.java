package com.Selenium.Library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GlobalLibrary extends Base {

	public WebDriver driver;

	public GlobalLibrary(WebDriver driver) {
		this.driver = driver;
	}

	

}
