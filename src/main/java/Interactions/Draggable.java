package Interactions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Draggable {
    WebDriver driver;
    Actions actions;

    @FindBy (id = "draggableExample-tab-simple")
    WebElement simpleTab;

    @FindBy (id = "dragBox")
    WebElement simpleDragBox;

    @FindBy (id = "draggableExample-tab-axisRestriction")
    WebElement axisRestrictedTab;

    @FindBy (id = "restrictedX")
    WebElement dragX;

    @FindBy (id = "restrictedY")
    WebElement dragY;

    @FindBy (id = "draggableExample-tab-containerRestriction")
    WebElement containerRestrictionTab;

    @FindBy (xpath = "//*[@id='containmentWrapper']/div")
    WebElement containedWithinBoxDragBox;

    @FindBy (id = "containmentWrapper")
    WebElement containmentWrapper;

    @FindBy (xpath = "//*[@id='draggableExample-tabpane-containerRestriction']/div[2]/span")
    WebElement containedWithinParentDragBox;

    @FindBy(xpath = "//*[@id='draggableExample-tabpane-containerRestriction']/div[2]")
    WebElement parentWrapper;

    @FindBy(id = "draggableExample-tab-cursorStyle")
    WebElement cursorStyleTab;

    @FindBy (id = "cursorCenter")
    WebElement cursorCenterDragBox;

    @FindBy (id = "cursorTopLeft")
    WebElement cursorTopLeftDragBox;

    @FindBy (id = "cursorBottom")
    WebElement cursorBottomDragBox;

    public Draggable (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public void simpleTabClick(){
        simpleTab.click();
    }

    public void dragSimpleBox(){
        actions.pause(Duration.ofMillis(500))
                .clickAndHold(simpleDragBox)
                .pause(Duration.ofMillis(300))
                .moveByOffset(300,0)
                .release()
                .perform();
    }

    public int[] simpleDragBoxPosition(){
        Point simpleDragPosition = simpleDragBox.getLocation();
        int width = simpleDragPosition.getX();
        int height = simpleDragPosition.getY();
        return new int[]{width, height};
    }
    //*////////////////////////////////

    public void axisRestrictedTabClick(){
        axisRestrictedTab.click();
    }

    public void dragXBox(){
        actions.pause(Duration.ofMillis(500))
                .clickAndHold(dragX)
                .pause(Duration.ofMillis(300))
                .moveByOffset(326,200)
                .release()
                .perform();
    }

    public void dragYBox(){
        actions.pause(Duration.ofMillis(500))
                .clickAndHold(dragY)
                .pause(Duration.ofMillis(300))
                .moveByOffset(200,39)
                .release()
                .perform();
    }

    public Point getXDragLocation(){
        return dragX.getLocation();
    }

    public Point getYDragLocation(){
        return dragY.getLocation();
    }
    //*////////////////////////////////

    public void containerRestrictionTabClick(){
        containerRestrictionTab.click();
    }

    public void dragContainedWithinBoxDragBox(){
        actions.pause(Duration.ofMillis(500))
                .clickAndHold(containedWithinBoxDragBox)
                .pause(Duration.ofMillis(300))
                .moveByOffset(700,300)
                .release()
                .perform();
    }

    public Rectangle getContainmentWrapperRect(){
        return containmentWrapper.getRect();
    }

    public Rectangle getContainedWithinBoxDragBoxRect(){
        return containedWithinBoxDragBox.getRect();
    }

    public void dragContainedWithinParentDragBox(){
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'})", parentWrapper);

        actions.pause(Duration.ofMillis(500))
                .clickAndHold(containedWithinParentDragBox)
                .pause(Duration.ofMillis(300))
                .moveByOffset(300,300)
                .release()
                .perform();
    }

    public Rectangle getParentWrapperRect(){
        return parentWrapper.getRect();
    }

    public Rectangle getContainedWithinParentDragBoxRect(){
        return containedWithinParentDragBox.getRect();
    }
    //*////////////////////////////////

    public void cursorStyleTabClick(){
        cursorStyleTab.click();
    }

    public void dragCursorCenterDragBox(){
        actions.pause(Duration.ofMillis(500))
                .clickAndHold(cursorCenterDragBox)
                .pause(Duration.ofMillis(300))
                .moveByOffset(300,0)
                .release()
                .perform();
    }

    public void dragCursorTopLeftDragBox(){
        actions.pause(Duration.ofMillis(500))
                .clickAndHold(cursorTopLeftDragBox)
                .pause(Duration.ofMillis(300))
                .moveByOffset(300,0)
                .release()
                .perform();
    }

    public void dragCursorBottomDragBox(){
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'})", cursorBottomDragBox);

        actions.pause(Duration.ofMillis(500))
                .clickAndHold(cursorBottomDragBox)
                .pause(Duration.ofMillis(300))
                .moveByOffset(300,0)
                .release()
                .perform();
    }

}