// Import statements for required Selenium classes
package com.example.seleniumtest1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Class demonstrating window-related activities
public class WindowActivities {

    // Main method where the execution begins
    public static void main(String[] args) {

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the Google website
        driver.get("https://www.google.com");

        // Navigate to the Flickr website
        driver.navigate().to("https://flickr.com");

        // Navigate back to the previous page
        driver.navigate().back();

        // Consider adding a cleanup step (driver.quit()) at the end of your script to close the browser and release resources
        // Example: driver.quit();
    }
}
