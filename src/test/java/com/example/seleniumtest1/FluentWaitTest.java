// Import statements for required Selenium classes and Java utilities
package com.example.seleniumtest1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

// Class demonstrating Fluent Wait in Selenium WebDriver
public class FluentWaitTest {

    // Main method where the execution begins
    public static void main(String[] args) {
        // Create a new instance of the FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Open the specified URL in the Firefox browser
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Click on the button with the specified CSS selector
        driver.findElement(By.cssSelector("[id='start'] button")).click();

        // Define FluentWait with a timeout, polling interval, and exceptions to ignore
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        // Use FluentWait to wait for an element to be displayed
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement temp = driver.findElement(By.cssSelector("[id='finish'] h4"));
                if (temp.isDisplayed()) {
                    return driver.findElement(By.cssSelector("[id='finish'] h4"));
                } else {
                    return null;
                }
            }
        });

        // Print the text of the displayed element
        System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());

        // Close the browser
        driver.quit();
    }
}
