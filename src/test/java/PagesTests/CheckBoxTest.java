package PagesTests;

import Elements.Pages.CheckBoxPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBoxTest {
    WebDriver driver;
    CheckBoxPage page;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");
        page = new CheckBoxPage(driver);
    }

    @Test
    public void checkBoxTest(){
        page.clickTreeOpener();
        page.clickTreeOpener();
        page.clickTreeOpener();
        page.clickTreeOpener();
        page.clickTreeOpener();
        page.clickTreeOpener();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        page.clickHomeButton();
        WebElement home = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("#result  span:nth-child(2)")));
        Assert.assertTrue(home.isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}