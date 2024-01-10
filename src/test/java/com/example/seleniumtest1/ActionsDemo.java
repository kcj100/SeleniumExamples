// Import statements for required Selenium classes
package com.example.seleniumtest1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

// Class demonstrating the usage of Actions class in Selenium WebDriver
public class ActionsDemo {

    // Main method where the execution begins
    public static void main(String[] args) {
        // Create a new instance of the FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Open the specified URL in the Firefox browser
        driver.get("https://www.amazon.com/");

        // Create an instance of the Actions class
        Actions actions = new Actions(driver);

        // Find the web element to be moved to
        WebElement move = driver.findElement(By.cssSelector("[id=nav-link-accountList]"));

        // Chain multiple actions together using Actions class
        actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox")))
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("hello")
                .doubleClick()
                .build()
                .perform();

        // Move to a different element and perform context-click
        actions.moveToElement(move).contextClick().build().perform();

        // Close the browser
        driver.quit();
    }
}
