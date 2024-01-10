// Import statements for required Selenium classes
package com.example.seleniumtest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Main class for the assignment
public class Assignment {

    // Main method where the execution begins
    public static void main(String[] args) {

        // Sample text to be used in the test
        String text = "Rahul";

        // Set the system property for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open the specified URL in the Chrome browser
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Locate the element with id "name" and enter the specified text
        driver.findElement(By.id("name")).sendKeys(text);

        // Click on the button with id "alertbtn"
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();

        // Print the text from the alert and accept the alert
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        // Locate the element with id "confirmbtn" and click on it
        driver.findElement(By.id("confirmbtn")).click();

        // Print the text from the confirmation alert and dismiss the alert
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }
}