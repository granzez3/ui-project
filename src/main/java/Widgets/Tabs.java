package Widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tabs {
    WebDriver driver;

    @FindBy(id = "demo-tab-what")
    WebElement what;

    @FindBy(id = "demo-tab-origin")
    WebElement origin;

    @FindBy(id = "demo-tab-use")
    WebElement use;

    @FindBy(id = "demo-tabpane-what")
    WebElement whatText;

    @FindBy(id = "demo-tabpane-origin")
    WebElement originText;

    @FindBy(id = "demo-tabpane-use")
    WebElement useText;

    public Tabs (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void whatClick(){
        what.click();
    }
    public void originClick(){
        origin.click();
    }
    public void useClick(){
        use.click();
    }

    public String getWhatText(){
        return whatText.getText();
    }
    public String getOriginText(){
        return originText.getText();
    }
    public String getUseText() {
        return useText.getText();
    }
}
