package practice;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class AngularFormPractice {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // name test
        String XPathNameInput = "//form//input[@name='name']";
        WebElement nameInputElement = driver.findElement(By.xpath(XPathNameInput));
        Assert.assertTrue(nameInputElement.getAttribute("value").isBlank());
        nameInputElement.sendKeys("John Smith");
        Assert.assertEquals(nameInputElement.getAttribute("value"), "John Smith");
        System.out.println(nameInputElement.getAttribute("value"));

        // email test
        String XPathEmailInput = "//form//input[@name='email']";
        WebElement emailInputElement = driver.findElement(By.xpath(XPathEmailInput));
        Assert.assertTrue(emailInputElement.getAttribute("value").isBlank());
        String email = "johnsmith123@someemail.com";
        emailInputElement.sendKeys(email);
        Assert.assertEquals(emailInputElement.getAttribute("value"), email);
        System.out.println(emailInputElement.getAttribute("value"));

        // password test
        String XPathPasswordInput = "//form//input[@id='exampleInputPassword1']";
        WebElement passwordInputElement = driver.findElement(By.xpath(XPathPasswordInput));
        Assert.assertTrue(passwordInputElement.getAttribute("value").isBlank());
        String password = "cool123";
        passwordInputElement.sendKeys(password);
        Assert.assertEquals(passwordInputElement.getAttribute("value"), password);
        System.out.println(passwordInputElement.getAttribute("value"));

        // checkbox test
        String XPathCheckbox = "//form//input[@id='exampleCheck1']";
        WebElement checkboxElement = driver.findElement(By.xpath(XPathCheckbox));
        Assert.assertFalse(checkboxElement.isSelected());
        checkboxElement.click();
        Assert.assertTrue(checkboxElement.isSelected());
        System.out.println("checkbox is selected: " + checkboxElement.isSelected());

        // gender select test
        String XPathGenderSelect = "//form//select[@id='exampleFormControlSelect1']";
        Select genderSelect = new Select(driver.findElement(By.xpath(XPathGenderSelect)));
        genderSelect.selectByIndex(1);
        Assert.assertEquals(genderSelect.getFirstSelectedOption().getAttribute("value"), "Female");
        System.out.println("gender selection: " + genderSelect.getFirstSelectedOption().getAttribute("value"));
        genderSelect.selectByIndex(0);
        Assert.assertEquals(genderSelect.getFirstSelectedOption().getAttribute("value"), "Male");
        System.out.println("gender selection: " + genderSelect.getFirstSelectedOption().getAttribute("value"));

        // employment status test
        String XPathEmploymentStatus = "//div[@class='form-group']//input[@class='form-check-input']";
        List<WebElement> employmentOptions = driver.findElements(By.xpath(XPathEmploymentStatus));
        WebElement studentOption = employmentOptions.get(0);
        Assert.assertFalse(studentOption.isSelected());
        studentOption.click();
        Assert.assertEquals(
                List.copyOf(studentOption.findElements(
                        By.xpath(XPathEmploymentStatus + "/parent::div/label")))
                        .get(0).getText()
                , "Student");
        Assert.assertTrue(studentOption.isSelected());
        System.out.println(List.copyOf(studentOption.findElements(
                By.xpath(XPathEmploymentStatus + "/parent::div/label")))
                .get(0).getText());

        // date of birth test
        String XPathDOB = "//form//input[@name='bday']";
        WebElement dobElement = driver.findElement(By.xpath(XPathDOB));
        Actions actions = new Actions(driver);
        actions.moveToElement(dobElement)
                .click()
                .sendKeys("2101990")
                .build()
                .perform();
        Assert.assertEquals(dobElement.getAttribute("value"), "1990-02-10");
        System.out.println(dobElement.getAttribute("value"));

        // submit test
        String XPathSubmitButton = "//form//input[@type='submit']";
        WebElement submitElement = driver.findElement(By.xpath(XPathSubmitButton));
        submitElement.click();
    }
}
