package WidgetsTests;

import Base.BaseTest;
import Widgets.Tabs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TabsTest extends BaseTest {
    Tabs page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/tabs");
        page = new Tabs(driver);
    }

    @Test
    public void tabsTest(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        page.originClick();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo-tabpane-origin")));

        Assert.assertTrue(page.getOriginText().contains("Contrary to popular belief, Lorem Ipsum"));

        page.useClick();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo-tabpane-use")));

        Assert.assertTrue(page.getUseText().contains("It is a long established fact that a reader"));

        page.whatClick();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo-tabpane-what")));

        Assert.assertTrue(page.getWhatText().contains("Lorem Ipsum is simply dummy text of the"));

    }
}
