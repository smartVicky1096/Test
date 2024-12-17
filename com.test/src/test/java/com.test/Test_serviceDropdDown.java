package com.test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_serviceDropdDown {
	
	@Test
	public void serDD() {
		
		WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ktig.info/");
		WebElement services = driver.findElement(By.xpath("//a[@href='ktig_services' and @class='nav-link dropdown-toggle']"));
        Actions actions =new Actions(driver);
        actions.moveToElement(services).build().perform();
        try {
            Thread.sleep(2000); // You can replace this with WebDriverWait if needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> dropdownItems = driver.findElements(By.linkText("services"));
        //List<WebElement> dropdownItems = driver.findElements(By.xpath("//a[@href='ktig_services' and @class='nav-link dropdown-toggle']"));
        System.out.println("Number of Services: " + dropdownItems.size());
      //*[@id="navbarCollapse"]/div[1]/div/div
		// Iterate over dropdown items and print visible text
		int count = 1;
        boolean matchFound = false;
        for (WebElement item : dropdownItems) {
            String itemText = item.getText().trim();

            // Print each service
            System.out.println("Service " + count + ": " + itemText);
            count++;

            // Check for the match and click
            if (itemText.equalsIgnoreCase("IT Solution")) {
                item.click();
                System.out.println("Match found: IT Solution");
                matchFound = true;
                break;
            }
        }

        if (!matchFound) {
            System.out.println("Match not found: IT Solution");
        }
 driver.quit();
 
}
}