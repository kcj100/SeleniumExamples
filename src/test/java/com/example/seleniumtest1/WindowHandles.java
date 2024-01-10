// Import statements for required Selenium classes and Java utilities
package com.example.seleniumtest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

// Class demonstrating the usage of window handles in Selenium WebDriver
public class WindowHandles {

    // Main method where the execution begins
    public static void main(String[] args) {
        // Create a new instance of the FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Open the specified URL in the Firefox browser
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        // Click on the element with the specified CSS selector
        driver.findElement(By.cssSelector(".blinkingText")).click();

        // Get the set of window handles
        Set<String> windows = driver.getWindowHandles();

        // Create an iterator to iterate through the window handles
        Iterator<String> it = windows.iterator();

        // Switch to the first window (parent window)
        String parentId = it.next();

        // Switch to the second window (child window)
        String childId = it.next();
        driver.switchTo().window(childId);

        // Set an implicit wait for the child window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // Print and extract text from the child window
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText()
                .split("at")[1]
                .trim()
                .split(" ")[0];
        System.out.println(emailId);

        // Switch back to the parent window
        driver.switchTo().window(parentId);

        // Enter the extracted email id in the parent window's input field
        driver.findElement(By.id("username")).sendKeys(emailId);

        // Close the browser
        driver.quit();
    }
}
