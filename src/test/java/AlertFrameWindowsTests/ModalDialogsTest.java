package AlertFrameWindowsTests;

import AlertFrameWindows.ModalDialogs;
import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ModalDialogsTest extends BaseTest {
    ModalDialogs page;

    @BeforeMethod
    public void pageInit () {
        driver.get("https://demoqa.com/modal-dialogs");
        page = new ModalDialogs(driver);
    }

    @Test
    public void modalDialogsTest(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        page.openSmallModal();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));

        Assert.assertEquals(page.getSmallModalTitle(), "Small Modal");
        Assert.assertEquals(page.getSmallModalText(), "This is a small modal. " +
                "It has very less content");
        page.closeSmallModal();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.modal-content")));

        page.openLargeModal();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));

        Assert.assertEquals(page.getLargeModalTitle(), "Large Modal");
        Assert.assertTrue(page.getLargeModalText().contains("Lorem Ipsum"));
        page.closeLargeModal();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.modal-content")));
    }
}
