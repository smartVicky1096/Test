package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Url {
	WebDriver driver;
	@BeforeMethod
	public void launch() {
		
		WebDriverManager.edgedriver().setup();
		 driver= new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://13.201.85.29:3000/");
	}
@Test
	public void useURL() {
	
	driver.get("http://13.201.85.29:3000/");
	}

public void conclude() {
	driver.quit();
	
}
}
