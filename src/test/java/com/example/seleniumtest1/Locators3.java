// Import statements for required Selenium classes
package com.example.seleniumtest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Class demonstrating the usage of different locators
public class Locators3 {

    // Main method where the execution begins
    public static void main(String[] args) {

        // Set the system property for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Sibling - Child to parent traverse
        // header/div/button[1]/following-sibling::button[1]

        // Open the specified URL in the Chrome browser
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Print the text of the button following the first button in the header
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());

        // Print the text of the second button in the parent div of the first button in the header
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());

        // Consider using more descriptive variable names for improved readability

        // Consider adding a cleanup step (driver.quit()) at the end of your script to close the browser and release resources
    }
}
