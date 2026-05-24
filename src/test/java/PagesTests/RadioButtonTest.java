package PagesTests;

import Pages.RadioButton;
import PagesTests.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RadioButtonTest extends BaseTest {
    private RadioButton page;

    @BeforeMethod
    public void initPage(){
        driver.get("https://demoqa.com/radio-button");
        page = new RadioButton(driver);
    }

    @Test
    public void radioButtonTest(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        page.clickYes();
        WebElement yes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Yes']")));
        Assert.assertTrue(yes.isDisplayed());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        page.clickImpressive();
        WebElement impressive = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Impressive']")));
        Assert.assertTrue(impressive.isDisplayed());
    }

}
