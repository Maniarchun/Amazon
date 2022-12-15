package com.amazon.Amazon;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.amazon.Amazon.XLSXRead;

public class FacebookInput {
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ELCOT\\eclipse-workspace\\Mydemo\\Browser\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.id("email"));
		String value = XLSXRead.singleDataReader("Data1", 1, 0);
		username.sendKeys(value);
		WebElement password = driver.findElement(By.id("pass"));
		String value1 = XLSXRead.singleDataReader("Data1", 1, 1);
		password.sendKeys(value1);
		driver.findElement(By.xpath("//button[@value='1']")).click();
		
	}
}
