// Import statements for required Selenium classes and Java utilities
package com.example.seleniumtest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

// Class demonstrating the usage of frames in Selenium WebDriver
public class FrameTest {

    // Main method where the execution begins
    public static void main(String[] args) {
        // Create a new instance of the FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Open the specified URL in the Firefox browser
        driver.get("http://jqueryui.com/droppable/");

        // Find all iframes on the page (not used in the current context)
        driver.findElements(By.xpath("//iframe"));

        // Switch to the iframe with the specified CSS selector
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

        // Create an instance of the Actions class
        Actions actions = new Actions(driver);

        // Find the source and target elements within the iframe
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        // Perform drag and drop action
        actions.dragAndDrop(source, target).build().perform();

        // Switch back to the default content (outside the iframe)
        driver.switchTo().defaultContent();

        // Close the browser
        driver.close();
    }
}
