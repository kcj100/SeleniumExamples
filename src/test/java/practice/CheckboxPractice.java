package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class CheckboxPractice {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String fieldSetLabelXPath = "//div[@id='checkbox-example']/fieldset/label/input";
        List<WebElement> checkboxes = driver.findElements(By.xpath(fieldSetLabelXPath));
        checkboxes.get(0).click();
        Assert.assertTrue(checkboxes.get(0).isSelected());
        int selectedCounter = 0;
        System.out.println(checkboxes.size());
    }
}
