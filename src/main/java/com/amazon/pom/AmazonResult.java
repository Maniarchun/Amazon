package com.amazon.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonResult {
	
public static WebDriver driver;


	
	@FindBy(xpath = "//span[text()='MORE RESULTS']//preceding::div[@class='sg-col-inner']")
	private List<WebElement> resultCount;
	
	@FindBy(xpath = "//span[text()='MORE RESULTS']//following::div[@class='sg-col-inner']")
	private List<WebElement> moreResultCount;
	
	
	public AmazonResult(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getResultCount() {
		return resultCount;
	}

	public List<WebElement> getMoreResultCount() {
		return moreResultCount;
	}

}
