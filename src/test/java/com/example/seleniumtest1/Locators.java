// Import statements for required Selenium classes
package com.example.seleniumtest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

// Class demonstrating the usage of different locators
public class Locators {

    // Main method where the execution begins
    public static void main(String[] args) throws InterruptedException {

        // Create a new instance of the FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Open the Google website
        driver.get("https://www.google.com/");

        // Find the element by id "APjFqb" and enter the text "cool"
        driver.findElement(By.id("APjFqb")).sendKeys("cool");

        // Introduce a delay for demonstration purposes (not recommended for actual test scripts)
        Thread.sleep(1000);

        // Find the element using XPath and click on it
        driver.findElement(By.xpath("//center/input[1]")).click();
    }
}
