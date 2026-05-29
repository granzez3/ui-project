package AlertFrameWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {
    WebDriver driver;

    @FindBy(id = "alertButton")
    WebElement alert;

    @FindBy(id = "timerAlertButton")
    WebElement timerAlert;

    @FindBy(id = "confirmButton")
    WebElement confirmAlert;

    @FindBy(id = "promtButton")
    WebElement promptAlert;

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    @FindBy (id = "promptResult")
    WebElement promptResult;

    public AlertPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void alertClick(){
        alert.click();
    }

    public void timerAlertClick(){
        timerAlert.click();
    }

    public void confirmAlertClick(){
        confirmAlert.click();
    }

    public String confirmResultText(){
        return confirmResult.getText();
    }

    public void promptAlertClick(){
        promptAlert.click();
    }

    public String promptResultText(){
        return promptResult.getText();
    }
}
