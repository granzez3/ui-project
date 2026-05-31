package AlertFrameWindowsTests;

import AlertFrameWindows.Frames;
import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FramesTest extends BaseTest {
    Frames page;

    @BeforeMethod
    public void initPage(){
        driver.get("https://demoqa.com/frames");
        page= new Frames(driver);
    }

    @Test
    public void framesTest(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame1")));
        Assert.assertTrue(driver.getPageSource().contains(page.getSampleText()));
        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame2")));
        Assert.assertEquals(page.getSampleText(), "This is a sample page");
        driver.switchTo().defaultContent();

    }
}
