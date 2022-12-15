package com.amazon.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SingleTonDesignPatten {
	public static WebDriver driver;

	public SingleTonDesignPatten(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}
	public AmazonHome getAmazonHome() {
		AmazonHome ah = new AmazonHome(driver);
		return ah;
	}
	public AmazonResult getAmazonResult() {
		AmazonResult ar = new AmazonResult(driver);
		return ar;
	}

}
