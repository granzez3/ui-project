package AlertFrameWindowsTests;

import AlertFrameWindows.AlertPage;
import Base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest extends BaseTest {
    AlertPage page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/alerts");
        page = new AlertPage(driver);
    }

    @Test
    public void alertTest(){

        page.alertClick();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You clicked a button");
        alert.accept();

        page.timerAlertClick();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "This alert appeared after 5 seconds");
        alert.accept();

        page.confirmAlertClick();
        alert.accept();
        Assert.assertEquals(page.confirmResultText(), "You selected Ok");
        page.confirmAlertClick();
        alert.dismiss();
        Assert.assertEquals(page.confirmResultText(), "You selected Cancel");

        page.promptAlertClick();
        alert.sendKeys("HypHons");
        alert.accept();
        Assert.assertEquals(page.promptResultText(), "You entered HypHons");
    }
}
