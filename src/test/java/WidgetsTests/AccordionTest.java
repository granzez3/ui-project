package WidgetsTests;

import Base.BaseTest;
import Widgets.Accordion;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AccordionTest extends BaseTest {
    Accordion page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/accordian");
        page = new Accordion(driver);
    }

    @Test
    public void accordionTest(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertTrue(page.getAccordion1Text().contains("Lorem Ipsum is simply dummy text"));
        page.accordion1Click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
                "//div[@class = 'accordion-item'][.//button[text() = 'What is Lorem Ipsum?']]" +
                        "//div[@class = 'accordion-body']")));

        page.accordion2Click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[@class = 'accordion-item'][.//button[text() = 'Where does it come from?']]" +
                        "//div[@class = 'accordion-body']")));
        Assert.assertTrue(page.getAccordion2Text().contains("Contrary to popular belief"));
        page.accordion2Click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
                "//div[@class = 'accordion-item'][.//button[text() = 'Where does it come from?']]" +
                        "//div[@class = 'accordion-body']")));

        page.accordion3Click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[@class = 'accordion-item'][.//button[text() = 'Why do we use it?']]" +
                        "//div[@class = 'accordion-body']")));
        Assert.assertTrue(page.getAccordion3Text().contains("Content here, content here"));
        page.accordion3Click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
                "//div[@class = 'accordion-item'][.//button[text() = 'Why do we use it?']]" +
                        "//div[@class = 'accordion-body']")));


    }
}
