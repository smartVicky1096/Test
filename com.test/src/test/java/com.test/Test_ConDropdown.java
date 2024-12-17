package com.test;

import java.time.Duration; // Import Duration class
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_ConDropdown {
    WebDriver driver;

    @Test
    public void contact() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://13.201.85.29:3000/");
        
        // Fill the form fields
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Vigneshwar CR");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("08870173336");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("vignesh22892@gmail.com");

        // Wait for the dropdown to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement ourService = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='service']")));
        
        // Interact with the dropdown
        Select serviceDropdown = new Select(ourService);
        serviceDropdown.selectByVisibleText("KTIG Groups");
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(" Test");
        
        WebElement Business = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='business']")));
        Select groupDropdown = new Select(Business);
        groupDropdown.selectByVisibleText("IT/ITES Services");
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[10]/div/div/div/div[2]/button")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();

        // Close the browser
        driver.quit();
    }
}

