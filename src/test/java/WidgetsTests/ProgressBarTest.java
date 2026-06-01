package WidgetsTests;

import Base.BaseTest;
import Widgets.ProgressBar;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProgressBarTest extends BaseTest {
    ProgressBar page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/progress-bar");
        page = new ProgressBar(driver);
    }

    @Test
    public void progressBarInfo(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        page.buttonCLick();

        wait.until(driver1 ->
                Integer.parseInt(
                        page.getProgressBarValue()
                ) >= 25);

        page.buttonCLick();

        System.out.println(page.getProgressBarValue());
    }
}
