package com.amazon.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHome {
	public static WebDriver driver;

	@FindBy(xpath = "//select[@id='searchDropdownBox']/option")
	private List<WebElement> options;

	@FindBy(xpath = "//select[@id='searchDropdownBox']//child::option[text()='\" + optionText + \"']")
	private WebElement optionsText;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	@FindBy(xpath = "//div[@class='autocomplete-results-container']/div/div/div")
	private List<WebElement> searchSuggest;

	@FindBy(xpath = "//div[@class='autocomplete-results-container']/div/div/div[@aria-label='\" + suggestText + \"'] ")
	private WebElement searchText;

	public AmazonHome(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getOptions() {
		return options;
	}

	public WebElement getOptionsText() {
		return optionsText;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public List<WebElement> getSearchSuggest() {
		return searchSuggest;
	}

	public WebElement getSearchText() {
		return searchText;
	}

}
