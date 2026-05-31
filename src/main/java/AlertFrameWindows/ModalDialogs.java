package AlertFrameWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalDialogs {
    WebDriver driver;

    @FindBy(id = "showSmallModal")
    WebElement smallModalBtn;

    @FindBy(id = "showLargeModal")
    WebElement largeModalBtn;

    @FindBy(id = "closeSmallModal")
    WebElement closeSmallModalBtn;

    @FindBy(id = "closeLargeModal")
    WebElement closeLargeModalBtn;

    @FindBy (id = "example-modal-sizes-title-sm")
    WebElement smallModalTitle;

    @FindBy (xpath = "//div[@class='modal-content'][.//div[text()='Small Modal']]//div[@class='modal-body']")
    WebElement smallModalText;

    @FindBy (id = "example-modal-sizes-title-lg")
    WebElement largeModalTitle;

    @FindBy (xpath = "//div[@class='modal-content'][.//div[text()='Large Modal']]//div[@class='modal-body']")
    WebElement largeModalText;


    public ModalDialogs (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openSmallModal(){
        smallModalBtn.click();
    }

    public void openLargeModal(){
        largeModalBtn.click();
    }

    public void closeSmallModal(){
        closeSmallModalBtn.click();
    }

    public void closeLargeModal(){
        closeLargeModalBtn.click();
    }

    public String getSmallModalTitle(){
        return smallModalTitle.getText();
    }

    public String getSmallModalText(){
        return smallModalText.getText();
    }

    public String getLargeModalTitle(){
        return largeModalTitle.getText();
    }

    public String getLargeModalText(){
        return largeModalText.getText();
    }

}