package AlertFrameWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFrames {
    WebDriver driver;

    @FindBy (xpath = "/html/body")
    WebElement parentFrameText;

    @FindBy (xpath = "//p[text() = 'Child Iframe']")
    WebElement childIframeText;

    public NestedFrames (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getParentFrameText(){
        return parentFrameText.getText();
    }

    public String getChildIframeText(){
        return childIframeText.getText();
    }
}
