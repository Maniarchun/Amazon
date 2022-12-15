package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.amazon.base.BaseClass;
import com.amazon.property.ConfigHelper;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\ELCOT\\eclipse-workspace\\Amazon\\src\\test\\java\\com\\feature\\Amazon.feature", 
				glue ="com.stepdefinition",
				monochrome = true,
				plugin ={"pretty",
						"html:Report/amzonHtmlReport.html",
						"junit:Report/amazonXmlReport.xml",
						"json:Report/amazonJsonReport.json"
						}
				)
public class RunnerAmazon extends BaseClass {
	public static WebDriver driver;
	@BeforeClass
	public static void setUp() throws IOException {
		String browser = ConfigHelper.getInstance().getBrowser();
		driver=BaseClass.browserLaunch(browser);
	}
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
