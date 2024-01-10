package com.example.seleniumtest1;

// Import statements for required Selenium classes and Java utilities
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Class demonstrating the addition of items to the cart on a shopping website
public class base {

    // Main method where the execution begins
    public static void main(String[] args) throws InterruptedException {

        // Set the system property for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Explicit wait with WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Array of items needed for shopping
        String[] itemsNeeded = {"Cucumber", "Broccoli", "Beetroot"};

        // Open the specified URL in the Chrome browser
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        // Introduce a delay for demonstration purposes (not recommended for actual test scripts)
        Thread.sleep(3000);

        // Call the method to add items to the cart
        addItems(driver, itemsNeeded);

        // Click on the cart icon
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();

        // Click on "PROCEED TO CHECKOUT" button
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        // Wait for visibility of the promo code input field
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

        // Enter the promo code
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

        // Click on the "Apply" button
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        // Wait for visibility of the promo information
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        // Print the promo information
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

        // Close the browser
        driver.quit();
    }

    // Method to add items to the cart based on the provided list
    public static void addItems(WebDriver driver, String[] itemsNeeded) {

        int j = 0;

        // List of all product elements on the page
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {

            // Extract the name of the product
            String[] name = products.get(i).getText().split("-");

            // Format the name to get the actual vegetable name
            String formattedName = name[0].trim();

            // Convert array into a list for easy search
            List<String> itemsNeededList = Arrays.asList(itemsNeeded);

            // Check whether the name you extracted is present in the list or not
            if (itemsNeededList.contains(formattedName)) {

                j++;

                // Click on "Add to cart" button
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                // Break if all items are added to the cart
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
    }
}
