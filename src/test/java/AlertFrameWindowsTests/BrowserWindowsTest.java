package AlertFrameWindowsTests;

import AlertFrameWindows.BrowserWindows;
import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class BrowserWindowsTest extends BaseTest {
    BrowserWindows page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/browser-windows");
        page = new BrowserWindows(driver);
    }

    @Test
    public void BWTest(){
        String mainWindow = driver.getWindowHandle();
        page.newTabClick();
        page.newWindowClick();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        Set<String> windows = driver.getWindowHandles();
        for(String window : windows){
            if(!(window.equals(mainWindow))){
                driver.switchTo().window(window);
                System.out.println(driver.getCurrentUrl());
                Assert.assertEquals(page.getSampleText(), "This is a sample page");
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void windowsMessageTest(){
        String mainWindow = driver.getWindowHandle();
        page.newWindowMessageClick();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> windows = driver.getWindowHandles();
        for(String window : windows){
            if(!(window.equals(mainWindow))){
                driver.switchTo().window(window);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
    }
}