// Import statements for required Selenium classes
package com.example.seleniumtest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

// Class demonstrating the usage of a static dropdown
public class StaticDropdown {

    // Main method where the execution begins
    public static void main(String[] args) {

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open the specified URL in the Chrome browser
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Locate the static dropdown element by its id
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        // Create a Select object using the WebElement
        Select dropdown = new Select(staticDropdown);

        // Select dropdown option by index (index starts from 0)
        dropdown.selectByIndex(3);

        // Print the text of the first selected option
        System.out.println("Selected currency by index: " + dropdown.getFirstSelectedOption().getText());

        // Select dropdown option by visible text
        dropdown.selectByVisibleText("AED");

        // Print the text of the first selected option
        System.out.println("Selected currency by visible text: " + dropdown.getFirstSelectedOption().getText());

        // Select dropdown option by value attribute
        dropdown.selectByValue("INR");

        // Print the text of the first selected option
        System.out.println("Selected currency by value: " + dropdown.getFirstSelectedOption().getText());

        // Consider adding a cleanup step (driver.quit()) at the end of your script to close the browser and release resources
    }
}
