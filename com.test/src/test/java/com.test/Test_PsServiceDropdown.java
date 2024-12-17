package com.test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

public class Test_PsServiceDropdown {
	@Test
	public void SpDd() {
		
		 WebDriverManager.edgedriver().setup();
	       WebDriver  driver = new EdgeDriver();
	       //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	        // Maximize window and navigate to Flipkart
	        driver.manage().window().maximize();
	        driver.get("https://www.flipkart.com");

	        // Close the login pop-up
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        WebElement electronicsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_1ch8e_ _1mZ8pZ']")));
	        new Actions(driver).moveToElement(electronicsMenu).perform();
	        driver.quit();
	}
}

