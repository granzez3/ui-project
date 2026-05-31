package AlertFrameWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Frames {
    WebDriver driver;

    @FindBy (id = "sampleHeading")
    WebElement sampleText;

    public Frames (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSampleText(){
        return sampleText.getText();
    }

}
