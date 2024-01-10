package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPageAndCartPractice {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector("#username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("#password")).sendKeys("learning");
        driver.findElement(By.cssSelector("#usertype")).click();
        Select typeDropdown = new Select(driver.findElement(By.cssSelector("select[class='form-control']")));
        typeDropdown.selectByValue("consult");
        driver.findElement(By.cssSelector("#terms")).click();
        driver.findElement(By.cssSelector("#signInBtn")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-footer']/button")));
        List<WebElement> devices = driver.findElements(By.xpath("//div[@class='card-footer']/button"));
        for (WebElement w : devices) {
            w.click();
        }
        driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
    }
}
