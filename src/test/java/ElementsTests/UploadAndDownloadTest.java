package ElementsTests;

import Elements.UploadAndDownload;
import Base.BaseDownloadTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class UploadAndDownloadTest extends BaseDownloadTest {
    UploadAndDownload page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/upload-download");
        page = new UploadAndDownload(driver);
    }

    @Test
    public void downloadTest(){

        File folder = new File("C:\\Users\\User\\IdeaProjects\\UI-Projects\\downloads");

        if(folder.exists()) {
            for (File file : folder.listFiles()) {
                file.delete();
            }
        }

        page.clickDownload();

        File downloadFile = new File(folder, "sampleFile.jpeg");


        int attempts = 0;
        while(attempts < 10){
            if(downloadFile.exists()) break;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            attempts++;
        }

        Assert.assertTrue(downloadFile.exists(), "Файл не скачался");
    }

    @Test
    public void uploadTest(){
        page.upload("d:\\WinUsers\\User\\Downloads\\sampleFile.jpeg");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement result = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("uploadedFilePath")));
        Assert.assertTrue(result.getText().contains("sampleFile.jpeg"), "Файл не загрузился");
    }
}