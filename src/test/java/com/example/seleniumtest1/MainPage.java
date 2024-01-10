// Import statements for required Selenium classes
package com.example.seleniumtest1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Class representing the main page of a website
// page_url = https://www.jetbrains.com/
public class MainPage {

    // Main method where the execution begins
    public static void main(String[] args) {

        // Create a new instance of the FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Open the Google website
        driver.get("https://www.google.com/");

        // Print the title of the current web page
        System.out.println(driver.getTitle());

        // Close the browser
        driver.close();
    }
}
