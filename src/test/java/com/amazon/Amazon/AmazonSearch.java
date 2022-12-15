package com.amazon.Amazon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.amazon.Amazon.XLSXRead;

public class AmazonSearch {
	public static WebDriver driver;
	static String optionsText; 
	static String searchText;

	public static void driverLunchh() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ELCOT\\eclipse-workspace\\KMT\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	public static void serchBox() {
		List<WebElement> listOfOption = driver.findElements(By.xpath("//select[@id='searchDropdownBox']/option"));
		List<String> optionList = new ArrayList<>();
		for (WebElement option : listOfOption) {
			optionList.add(option.getText());
		}
		for (String optionText : optionList) {
			if (optionsText.equalsIgnoreCase(optionText)) {
				driver.findElement(By.xpath("//select[@id='searchDropdownBox']//child::option[text()='" + optionText + "']")).click();
				break;
			}else {
				continue;
			}
		}
	}
	public static void particularElementClick() throws InterruptedException {
		List<String> suggestList = new ArrayList<>();
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys(searchText);
		Thread.sleep(3000);
		List<WebElement> searchSuggest = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']/div/div/div"));
		for (WebElement suggest : searchSuggest) {
			suggestList.add(suggest.getText());
		}
		for (String suggestText : suggestList) {
			if (searchText.equalsIgnoreCase(suggestText)) {
				driver.findElement(By
						.xpath("//div[@class='autocomplete-results-container']/div/div/div[@aria-label='" + suggestText + "']")).click();
				break;
			}else {
				continue;
			}
		}	
	}

	public static void findProductCount() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> result = driver.findElements(By.xpath("//span[text()='MORE RESULTS']//preceding::div[@class='sg-col-inner']"));
		System.out.println("Result Count : "+result.size());
		List<WebElement> moreResult = driver.findElements(By.xpath("//span[text()='MORE RESULTS']//following::div[@class='sg-col-inner']"));
		System.out.println("More result Count : "+moreResult.size());
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		optionsText	= XLSXRead.singleDataReader("Amazon", 3, 0);
		searchText = XLSXRead.singleDataReader("Amazon", 3, 1);
		driverLunchh();
		serchBox();
		particularElementClick();
		findProductCount();
	}

}
