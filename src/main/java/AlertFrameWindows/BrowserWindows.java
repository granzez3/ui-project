package AlertFrameWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWindows {
    WebDriver driver;

    @FindBy(id = "tabButton")
    WebElement newTab;

    @FindBy(id = "windowButton")
    WebElement newWindow;

    @FindBy (id = "messageWindowButton")
    WebElement newWindowMessage;

    @FindBy (id = "sampleHeading")
    WebElement sampleText;

    public BrowserWindows (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void newTabClick(){
        newTab.click();
    }

    public String getSampleText(){
        return sampleText.getText();
    }

    public void newWindowClick(){
        newWindow.click();
    }

    public void newWindowMessageClick(){
        newWindowMessage.click();
    }
}
