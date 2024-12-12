package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Mousehover {
	WebDriver driver;
	@Test
	public void KTIGWebMousehover() {
		
		WebDriverManager.edgedriver().setup();
         driver =new EdgeDriver();
         driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
         driver.manage().window().maximize();
         driver.get("http://13.201.85.29:3000/");
         WebElement services = driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/div[1]/div/a"));
         Actions actions =new Actions(driver);
         actions.moveToElement(services).build().perform();
         driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
         driver.quit();
	}

}
