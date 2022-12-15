package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amazon.Amazon.XLSXRead;
import com.amazon.base.BaseClass;
import com.amazon.pom.SingleTonDesignPatten;
import com.amazon.property.ConfigHelper;
import com.runner.RunnerAmazon;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass {
	public static WebDriver driver = RunnerAmazon.driver;
	static String optionsText;
	static String searchText;
	SingleTonDesignPatten stdp = new SingleTonDesignPatten(driver);

	@Given("user Launch The Application Url")
	public void user_Launch_The_Application_Url() throws Throwable {
		String url = ConfigHelper.getInstance().geturl();
		urlLaunch(url);
	}

	@When("user Select The Category From DropDown")
	public void user_Select_The_Category_From_DropDown() throws Throwable {
		optionsText = XLSXRead.singleDataReader("Amazon", 3, 0);
		List<WebElement> listOfOption = stdp.getAmazonHome().getOptions();
		List<String> optionList = new ArrayList<>();
		for (WebElement option : listOfOption) {
			optionList.add(option.getText());
		}
		for (String optionText : optionList) {
			if (optionsText.equalsIgnoreCase(optionText)) {
				WebElement element = driver.findElement(By.xpath("//select[@id='searchDropdownBox']//child::option[text()='" + optionText + "']"));
//						stdp.getAmazonHome().getOptionsText();
				clickElement(element);
				break;
			} else {
				continue;
			}
		}
	}

	@When("user Search The Product In Search Box")
	public void user_Search_The_Product_In_Search_Box() throws Throwable {

		searchText = XLSXRead.singleDataReader("Amazon", 3, 1);
		List<String> suggestList = new ArrayList<>();
		WebElement searchBox = stdp.getAmazonHome().getSearchBox();
		searchBox.sendKeys(searchText);
		sleep();

		List<WebElement> searchSuggest = stdp.getAmazonHome().getSearchSuggest();
		for (WebElement suggest : searchSuggest) {
			suggestList.add(suggest.getText());
		}

		for (String suggestText : suggestList) {
			if (searchText.equalsIgnoreCase(suggestText)) {
				WebElement element = driver.findElement(By.xpath("//div[@class='autocomplete-results-container']/div/div/div[@aria-label='" + suggestText + "']"));
//						stdp.getAmazonHome().getSearchText();
				clickElement(element);

				break;
			} else {
				continue;
			}

		}

	}

	@Then("user Click The Right Suggetion For The Requirement")
	public void user_Click_The_Right_Suggetion_For_The_Requirement() throws Throwable {
		sleep();
		List<WebElement> result = stdp.getAmazonResult().getResultCount();
		System.out.println("Result Count : " + result.size());
		List<WebElement> moreResult = stdp.getAmazonResult().getMoreResultCount();
		System.out.println("More result Count : " + moreResult.size());

	}

}
