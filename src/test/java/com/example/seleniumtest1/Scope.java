package com.example.seleniumtest1;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.xpath("//a")).size());
        WebElement columnDriver = footerDriver
                .findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        for (WebElement element : columnDriver.findElements(By.tagName("a"))) {
            if (driver.findElement(By.xpath("//td[1]/ul/li[1]/h3/a")).getText().equalsIgnoreCase(element.getText())) {
                continue;
            }
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            element.sendKeys(clickOnLinkTab);
            Thread.sleep(3000L);
        }
        driver.quit();
    }
}
//Wait<WebDriver> wait = new FluentWait<>(driver)
//        .withTimeout(Duration.ofSeconds(30))
//        .pollingEvery(Duration.ofSeconds(3))
//        .ignoring(NoSuchElementException.class);
//int windowsCount = 1;
//String mainHandle = driver.getWindowHandle();
//Set<String> windows = driver.getWindowHandles();
//List<String> handlesList = new ArrayList<>(windows);
//        for (WebElement element : columnDriver.findElements(By.tagName("a"))) {
//        if (driver.findElement(By.xpath("//td[1]/ul/li[1]/h3/a")).getText().equalsIgnoreCase(element.getText())) {
//        continue;
//        }
//String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
//            element.sendKeys(clickOnLinkTab);
//Set<String> newWindows = driver.getWindowHandles();
//            for (String window : newWindows) {
//        if (!windows.contains(window)) {
//        handlesList.add(window);
//                }
//                        }
//                        driver.switchTo().window(handlesList.get(handlesList.size() - 1));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a")));
//        driver.switchTo().window(mainHandle);
//        }
//                System.out.println(handlesList.size());