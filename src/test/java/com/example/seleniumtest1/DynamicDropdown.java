// Import statements for required Selenium classes
package com.example.seleniumtest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Class for handling dynamic dropdown in SpiceJet website
public class DynamicDropdown {

    // Main method where the execution begins
    public static void main(String[] args) throws InterruptedException {

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open the SpiceJet website
        driver.get("http://spicejet.com");

        // Click on the element with class name "r-1wtj0ep" (assumed to be related to the dropdown)
        driver.findElement(By.className("r-1wtj0ep")).click();

        // Click on the dropdown option with value 'BLR' using XPath
        driver.findElement(By.xpath("//a[@value='BLR']")).click();

        // Introduce a delay for demonstration purposes (not recommended for actual test scripts)
        Thread.sleep(2000);

        // Click on the dropdown option with value 'MAA' using XPath
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        // Click on the date picker using CSS selector
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
    }
}
