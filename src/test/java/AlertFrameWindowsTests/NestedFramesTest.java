package AlertFrameWindowsTests;

import AlertFrameWindows.NestedFrames;
import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFramesTest extends BaseTest {
    NestedFrames page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/nestedframes");
        page = new NestedFrames(driver);
    }

    @Test
    public void nestedFramesTest(){
        driver.switchTo().frame("frame1");
        Assert.assertEquals(page.getParentFrameText(), "Parent frame");
        WebElement frame = driver.findElement(By.cssSelector("body > iframe"));
        driver.switchTo().frame(frame);
        Assert.assertEquals(page.getChildIframeText(), "Child Iframe");
        driver.switchTo().defaultContent();
    }
}
