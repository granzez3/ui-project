package Interactions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Droppable {
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    @FindBy (id = "droppableExample-tab-simple")
    WebElement simpleTab;

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
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void simpleTabClick(){
        simpleTab.click();
    }

    public void setSimpleDrag(){
        actions.pause(Duration.ofMillis(500))
                .clickAndHold(simpleDrag)
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
        actions.pause(Duration.ofMillis(500))
                .clickAndHold(notAcceptableDrag)
                .pause(Duration.ofMillis(300))
                .moveToElement(acceptDrop)
                .release()
                .perform();
    }

    public void setAcceptableDrag(){
        actions.pause(Duration.ofMillis(500))
                .clickAndHold(acceptableDrag)
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
        actions.pause(Duration.ofMillis(500))
                .moveToElement(dragBox)
                .clickAndHold(dragBox)
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

        actions.pause(Duration.ofMillis(500))
                .clickAndHold(dragBox)
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
        actions.pause(Duration.ofMillis(500))
                .clickAndHold(revertableDrag)
                .pause(Duration.ofMillis(300))
                .moveToElement(revertableTabDrop)
                .release()
                .perform();
    }

    public int[] getRevertableDragPosition(){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Point elementPosition = revertableDrag.getLocation();
        int x = elementPosition.getX();
        int y = elementPosition.getY();
        return new int[]{x,y};
    }

    public int[] getNotRevertableDragPosition(){
        Point elementPosition = notRevertableDrag.getLocation();
        int x = elementPosition.getX();
        int y = elementPosition.getY();
        return new int[]{x,y};
    }

    public void setNotRevertableDrag(){
        actions.pause(Duration.ofMillis(500))
                .clickAndHold(notRevertableDrag)
                .pause(Duration.ofMillis(300))
                .moveToElement(revertableTabDrop)
                .release()
                .perform();
    }
}
