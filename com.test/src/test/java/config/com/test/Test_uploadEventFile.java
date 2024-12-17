package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_uploadEventFile {
	
	
	@Test
	public void UpFileEvent() {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ktig.info/Adminpage");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
	      driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ktig@123");
	      driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/button")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[1]/form/label[1]/input")).sendKeys("C:\\Users\\ADMIN\\Desktop\\monish\\com.test\\src\\test\\java");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[1]/form/label[2]/input")).sendKeys("School Test");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[1]/form/label[3]/textarea")).sendKeys(" School inagural");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[1]/form/button")).click();
		driver.quit();
		
	}

}
