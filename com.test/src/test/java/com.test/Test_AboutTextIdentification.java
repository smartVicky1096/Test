package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_AboutTextIdentification {
	@Test
	
	public void Textknown() {
		
		WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://13.201.85.29:3000/");
        WebElement Aboutelement = driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/div[1]/a[2]"));
        Aboutelement.click();
        
        WebElement KtigWord = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/body/div[4]/div/div/div/div[1]/h1"));
        KtigWord.click();
        
        String headingText = KtigWord.getText();
        System.out.println(" the text recived is " + headingText);
        
        driver.quit();
        }

}
