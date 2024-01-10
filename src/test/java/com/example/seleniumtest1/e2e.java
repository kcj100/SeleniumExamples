// Import statements for required Selenium classes and TestNG Assert
package com.example.seleniumtest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

// Class representing an end-to-end test scenario
public class e2e {

    // Main method where the execution begins
    public static void main(String[] args) throws InterruptedException {

        // Set the system property for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open the SpiceJet website
        driver.get("http://spicejet.com"); // URL in the browser

        // Select one-way trip
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

        // Click on the origin station dropdown
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        // Select the origin station as DEL
        driver.findElement(By.xpath("//a[@value='DEL']")).click();

        // Introduce a delay for demonstration purposes (not recommended for actual test scripts)
        Thread.sleep(2000);

        // Select the destination station as MAA
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        // Click on the date picker
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

        // Check if the option with id "Div1" is disabled
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
            System.out.println("It's disabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

        // Click on the Senior Citizen Discount checkbox
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        // Click on the passenger information dropdown
        driver.findElement(By.id("divpaxinfo")).click();

        // Introduce a delay for demonstration purposes (not recommended for actual test scripts)
        Thread.sleep(2000L);

        // Increase the number of adult passengers to 5
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        // Close the passenger options
        driver.findElement(By.id("btnclosepaxoption")).click();

        // Assert that the displayed passenger information is "5 Adult"
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        // Click on the search button
        driver.findElement(By.cssSelector("input[value='Search']")).click();
    }
}
