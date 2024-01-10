// Import statements for required Selenium classes and TestNG Assert
package com.example.seleniumtest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

// Class demonstrating dropdown and assertion interactions
public class UpdatedDropdown {

    // Main method where the execution begins
    public static void main(String[] args) throws InterruptedException {

        // Create a new instance of the FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Open the SpiceJet website
        driver.get("https://spicejet.com");

        // Reopen the SpiceJet website (duplicate call, consider removing one)
        driver.get("http://spicejet.com");

        // Assert that the Senior Citizen Discount checkbox is not selected initially
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        // Click on the Senior Citizen Discount checkbox
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        // Print whether the Senior Citizen Discount checkbox is selected after clicking
        System.out.println("Is Senior Citizen Discount selected: " +
                driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        // Assert that the Senior Citizen Discount checkbox is selected after clicking
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        // Click on the passenger information dropdown
        driver.findElement(By.id("divpaxinfo")).click();

        // Introduce a delay for demonstration purposes (not recommended for actual test scripts)
        Thread.sleep(2000L);

        // Print the text from the passenger information dropdown
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        // Increase the number of adult passengers to 5
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        // Close the passenger options
        driver.findElement(By.id("btnclosepaxoption")).click();

        // Assert that the displayed passenger information is "5 Adult"
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

        // Print the text from the passenger information dropdown
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        // Consider adding a cleanup step (driver.quit()) at the end of your script to close the browser and release resources
    }
}
