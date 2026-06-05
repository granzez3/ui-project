package Interactions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Droppable {
    WebDriver driver;
    Actions actions;

    @FindBy (id = "draggable")
    WebElement simpleDrag;

    @FindBy (id = "droppable")
    WebElement simpleDrop;

    @FindBy (id = "droppableExample-tab-accept")
    WebElement acceptTab;

    @FindBy (id = "acceptable")
    WebElement acceptableDrag;

    @FindBy (xpath = "//div[text() = 'Not Acceptable']")
    WebElement notAcceptableDrag;

    @FindBy (xpath = "//div[@id = 'acceptDropContainer']/div[2]")
    WebElement acceptDrop;

    @FindBy(id = "droppableExample-tab-preventPropogation")
    WebElement preventPropogationTab;

    @FindBy (id = "dragBox")
    WebElement dragBox;

    @FindBy (id = "notGreedyDropBox")
    WebElement notGreedyDropBox;

    @FindBy(xpath = "//div[@id = 'notGreedyDropBox']/p")
    WebElement notGreedyOuterBoxText;

    @FindBy (id = "notGreedyInnerDropBox")
    WebElement notGreedyInnerDropBox;

    @FindBy (id = "greedyDropBox")
    WebElement greedyDropBox;

    @FindBy(xpath = "//div[@id = 'greedyDropBox']/p")
    WebElement greedyOuterBoxText;

    @FindBy (id = "greedyDropBoxInner")
    WebElement greedyDropBoxInner;

    @FindBy (id = "droppableExample-tab-revertable")
    WebElement revertableTab;

    @FindBy (id = "revertable")
    WebElement revertableDrag;

    @FindBy (id = "notRevertable")
    WebElement notRevertableDrag;

    @FindBy (xpath = "//div[@id = 'revertableDropContainer']/div[@id = 'droppable']")
    WebElement revertableTabDrop;

    public Droppable(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void setSimpleDrag(){
        actions.clickAndHold(simpleDrag)
                .pause(Duration.ofMillis(300))
                .moveToElement(simpleDrop)
                .release()
                .perform();
    }

    public String getSimpleDropColor(){
        return Color.fromString(simpleDrop.getCssValue("background-color")).asHex();
    }
    //

    public void acceptTabClick(){
        acceptTab.click();
    }

    public void setNotAcceptableDrag(){
        actions.clickAndHold(notAcceptableDrag)
                .pause(Duration.ofMillis(300))
                .moveToElement(acceptDrop)
                .release()
                .perform();
    }

    public void setAcceptableDrag(){
        actions.clickAndHold(acceptableDrag)
                .pause(Duration.ofMillis(300))
                .moveToElement(acceptDrop)
                .release()
                .perform();
    }

    public String getAcceptDropAttribute(){
        return acceptDrop.getAttribute("class");
    }
    //

    public void preventPropogationTabeClick(){
        preventPropogationTab.click();
    }

    public void dragToNotGreedyInnerBox(){
        actions.clickAndHold(dragBox)
                .pause(Duration.ofMillis(300))
                .moveToElement(notGreedyInnerDropBox)
                .release()
                .perform();
    }

    public String getNotGreedyOuterBoxText(){
        return notGreedyOuterBoxText.getText();
    }

    public void dragToGreedyInnerBox(){
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'})", greedyDropBoxInner);

        actions.clickAndHold(dragBox)
                .pause(Duration.ofMillis(300))
                .moveToElement(greedyDropBoxInner)
                .release()
                .perform();
    }

    public String getGreedyOuterBoxText(){
        return greedyOuterBoxText.getText();
    }
    //

    public void revertableTabClick(){
        revertableTab.click();
    }

    public void setRevertableDrag(){
        actions.clickAndHold(revertableDrag)
                .pause(Duration.ofMillis(300))
                .moveToElement(revertableTabDrop)
                .release()
                .perform();
    }

    public int revertableDragGetX(){
        Point elementPosition = revertableDrag.getLocation();
        return elementPosition.getX();
    }
    public int revertableDragGetY(){
        Point elementPosition = revertableDrag.getLocation();
        return elementPosition.getY();
    }

    public static ExpectedCondition<Boolean> elementAtPosition(WebElement element, int x, int y){
        return driver -> {
            Point p = element.getLocation();
            return p.getX() == x && p.getY() == y;
        };
    }
    public WebElement revertableDrag(){
        return revertableDrag;
    }
    public void setNotRevertableDrag(){
        actions.clickAndHold(notRevertableDrag)
                .pause(Duration.ofMillis(300))
                .moveToElement(revertableTabDrop)
                .release()
                .perform();
    }
}
