package Elements.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadAndDownload {
    WebDriver driver;

    @FindBy(id = "downloadButton")
    WebElement download;

    @FindBy(id = "uploadFile")
    WebElement upload;

    public UploadAndDownload(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickDownload(){
        download.click();
    }

    public void upload(String path){
        upload.sendKeys(path);
    }

}
