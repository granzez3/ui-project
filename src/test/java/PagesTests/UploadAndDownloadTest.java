package PagesTests;

import Pages.UploadAndDownload;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class UploadAndDownloadTest extends BaseDownloadTest {
    UploadAndDownload page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/upload-download");
        page = new UploadAndDownload(driver);
    }

    @Test
    public void UAndDTest(){

        File folder = new File("D:\\WinUsers\\User\\Downloads");

        if(folder.exists()) {
            for (File file : folder.listFiles()) {
                file.delete();
            }
        }

        page.clickDownload();

        File downloadFile = new File(folder,"sampleFile.jpeg");


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
}