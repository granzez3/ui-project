package InteractionsTests;

import Base.BaseTest;
import Interactions.Droppable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;

public class DroppableTest extends BaseTest {
    Droppable page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/droppable");
        page= new Droppable(driver);
    }

    @Test
    public void droppableTest(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        //wait for elements to stabilize
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        page.setSimpleDrag();
//        Assert.assertEquals(page.getSimpleDropColor(), "#4682b4");
//
//        page.acceptTabClick();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acceptDropContainer")));
//        page.setNotAcceptableDrag();
//        Assert.assertNotEquals(page.getAcceptDropAttribute(), "drop-box ui-droppable ui-state-highlight");
//        page.setAcceptableDrag();
//        Assert.assertEquals(page.getAcceptDropAttribute(), "drop-box ui-droppable ui-state-highlight");
//
//        page.preventPropogationTabeClick();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ppDropContainer")));
//        page.dragToNotGreedyInnerBox();
//        Assert.assertEquals(page.getNotGreedyOuterBoxText(),"Dropped!");
//        page.dragToGreedyInnerBox();
//        Assert.assertNotEquals(page.getGreedyOuterBoxText(), "Dropped!");

        page.revertableTabClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revertableDropContainer")));
        page.revertableDragGetX();
        page.revertableDragGetY();
        page.setRevertableDrag();
        wait.until(page.elementAtPosition(page.revertableDrag(), page.revertableDragGetX(), page.revertableDragGetY()));
    }
}
