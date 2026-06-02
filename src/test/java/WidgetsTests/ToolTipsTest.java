package WidgetsTests;

import Base.BaseTest;
import Widgets.ToolTips;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ToolTipsTest extends BaseTest {
    ToolTips page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/tool-tips");
        page = new ToolTips(driver);
    }

    @Test
    public void toolTipsTest(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        page.hoverButton();
        wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.id("toolTipButton")),
                "aria-describedby", "buttonToolTip"));

        page.hoverTextField();
        wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.id("toolTipTextField")),
                "aria-describedby","textFieldToolTip"));

        page.hoverContrary();
        wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.xpath("//a[text()='Contrary']")),
                "aria-describedby","contraryTexToolTip"));

        page.hoverNumbers();
        wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.xpath("//a[text() = '1.10.32']")),
                "aria-describedby", "sectionToolTip"));
    }
}