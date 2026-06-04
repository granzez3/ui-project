package Interactions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Resizable {
    WebDriver driver;
    Actions actions;

    @FindBy(css = "#resizableBoxWithRestriction > .react-resizable-handle")
    WebElement restrictedDrag;

    @FindBy(css = "#resizable > .react-resizable-handle")
    WebElement unrestrictedDrag;

    @FindBy(id = "resizableBoxWithRestriction")
    WebElement resizableBoxWithRestriction;

    @FindBy (id = "resizable")
    WebElement resizableBox;

    public Resizable(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public void moveRestrictedDrag(){
        actions.moveToElement(restrictedDrag)
                .clickAndHold(restrictedDrag)
                .pause(Duration.ofMillis(300))
                .moveByOffset(100,100)
                .release()
                .perform();
    }

    public int[] sizeOfResizableBoxWithRestriction(){
        Dimension size = resizableBoxWithRestriction.getSize();
        int width = size.getWidth();
        int height = size.getHeight();

        return new int[]{width, height};
    }

    public void moveUnrestrictedDrag(){
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'})", unrestrictedDrag);

        actions.moveToElement(unrestrictedDrag)
                .clickAndHold(unrestrictedDrag)
                .pause(Duration.ofMillis(300))
                .moveByOffset(300,0)
                .release()
                .perform();
    }

    public int[] sizeOfResizableBox(){
        Dimension size = resizableBox.getSize();
        int width = size.getWidth();
        int height = size.getHeight();

        return new int[]{width, height};
    }
}
