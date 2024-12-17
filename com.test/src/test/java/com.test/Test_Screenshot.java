package com.test;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Test_Screenshot {
	
	@Test
    public void imagePresent() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://13.201.85.29:3000/");

        List<WebElement> KtigImage = driver.findElements(By.xpath("//img"));
        System.out.println("Total images found: " + KtigImage.size());

        // Loop through each image and take a screenshot
        for (int i = 0; i < KtigImage.size(); i++) {
            WebElement image = KtigImage.get(i);
            try {
                // Check if the image is displayed and has non-zero width and height
                if (image.isDisplayed() && image.getSize().getWidth() > 0 && image.getSize().getHeight() > 0) {
                    // Capture screenshot of the image element
                    File screenshot = image.getScreenshotAs(OutputType.FILE);
                    // Define file path for saving the screenshot
                    File destination = new File("C:\\Users\\ADMIN\\Desktop\\monish\\com.test\\src\\test\\java\\image_" + (i + 1) + ".png");
                    // Save the screenshot
                    FileHandler.copy(screenshot, destination);
                    System.out.println("Screenshot saved for image " + (i + 1) + " at: " + destination.getAbsolutePath());
                } else {
                    System.out.println("Skipping image " + (i + 1) + " as it is either not displayed or has zero size.");
                }
            } catch (IOException e) {
                System.out.println("Error capturing screenshot for image " + (i + 1) + ": " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error for image " + (i + 1) + ": " + e.getMessage());
            }
        }

        driver.quit();
    }
}