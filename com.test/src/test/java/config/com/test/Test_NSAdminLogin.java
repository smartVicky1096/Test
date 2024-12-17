package com.test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_NSAdminLogin {
	@Test
	public  void NSAccess() {
		
		WebDriverManager.edgedriver().setup();
	       WebDriver driver = new EdgeDriver();
	       driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	       driver.manage().window().maximize();
	       driver.get("https://ktig.info/");
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	       WebElement Al = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Admin Login")));
	       
	      try {
	       Al.click();
	      }
	      catch(org.openqa.selenium.ElementClickInterceptedException e){
	    	  JavascriptExecutor js = (JavascriptExecutor) driver;
	    	    js.executeScript("arguments[0].click();", Al);

	      }
	      
	      driver.findElement(By.xpath("//input[@name='username']")).sendKeys("vignesh");
	      driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
	      driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/button")).click();
	      try{
	    	  Alert alert =wait.until(ExpectedConditions.alertIsPresent());
	    	  System.out.println("Alert Text is: " + alert.getText());
	    	  alert.accept();
	      }
	      catch(Exception e) {
	    	  System.out.println(" No Alert is present ");
	      }
	      driver.quit();
	      
		}

	

	}


