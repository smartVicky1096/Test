package com.test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_logoIdentification {
	
	WebDriver driver;
	@Test
	public void logoImageIdentification() {
		
		WebDriverManager.edgedriver().setup();
		driver =new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://13.201.85.29:3000/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		try {
		WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[1]/nav/a/div/h1/img")));
		
		if(image.isDisplayed()) {
		System.out.println(" logo is displayed");
		}
		else {
			System.out.println(" logo is not displayed ");
		}
		}
		catch(Exception e) {
			System.out.println(" Exception occured :" + e.getMessage());
		}finally {
			driver.quit();
		}
		
		
	}

}
