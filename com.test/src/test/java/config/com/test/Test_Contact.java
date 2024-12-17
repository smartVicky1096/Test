package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.edge.EdgeDriver;

public class Test_Contact {
	WebDriver driver;
	
	@BeforeMethod
	public void launch() {
		
	
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	
}

	@Test
	public void contact() {
		driver.get("http://13.201.85.29:3000/");
		driver.findElement(By.xpath("//input[@name='name']"));

}
	@AfterMethod
	public void conclude() {
		driver.quit();
		
	}
}


