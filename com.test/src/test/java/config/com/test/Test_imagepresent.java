package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_imagepresent {
	@Test
	public void imagePresent() {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver =new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://13.201.85.29:3000/");
		List<WebElement> KtigImage = driver.findElements(By.xpath("//img"));
		System.out.println(KtigImage.size());
		driver.quit();
	}

}
