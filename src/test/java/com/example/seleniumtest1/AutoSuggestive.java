// Import statements for required Selenium classes
package com.example.seleniumtest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

// Class for demonstrating auto-suggestive dropdown selection
public class AutoSuggestive {

    // Main method where the execution begins
    public static void main(String[] args) throws InterruptedException {

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open the specified URL in the Chrome browser
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Locate the element with id "autosuggest" and enter the partial text "ind"
        driver.findElement(By.id("autosuggest")).sendKeys("ind");

        // Introduce a delay for demonstration purposes (not recommended for actual test scripts)
        Thread.sleep(3000);

        // Find all elements with the specified CSS selector for auto-suggestive options
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        // Iterate through the options and click on the option with text "India" if found
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }
    }
}
