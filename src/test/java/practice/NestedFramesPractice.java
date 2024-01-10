package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NestedFramesPractice {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.xpath("//a[contains(text(), 'Nested Frames')]")).click();
        driver.switchTo().frame(driver.findElement(By.name("frame-top")));
        driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
        System.out.println(driver.findElement(By.xpath("//div")).getText());
    }
}
