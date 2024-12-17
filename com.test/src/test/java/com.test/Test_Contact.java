package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

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
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Vigneshwar CR ");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("08870173336");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("vignesh22892@gmail.com");
		WebElement ourService = driver.findElement(By.xpath("//select[@name='service']"));
		ourService.click();
		Select serviceDropdown = new Select(ourService);
		serviceDropdown.selectByValue("KTIG Groups");

}
	@AfterMethod
	public void conclude() {
		driver.quit();
		
	}
}

