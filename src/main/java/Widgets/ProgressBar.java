package Widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressBar {
    WebDriver driver;

    @FindBy (id = "startStopButton")
    WebElement button;

    @FindBy (css = ".progress-bar")
    WebElement progressBar;


    public ProgressBar(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void buttonCLick(){
        button.click();
    }

    public String getProgressBarValue(){
        return progressBar.getAttribute("aria-valuenow");
    }

}
