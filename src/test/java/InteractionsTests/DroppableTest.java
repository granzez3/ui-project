package InteractionsTests;

import Base.BaseTest;
import Interactions.Droppable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DroppableTest extends BaseTest {
    Droppable page;
    WebDriverWait wait;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/droppable");
        page= new Droppable(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void simpleDragTest() {
        page.simpleTabClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("simpleDropContainer")));
        page.setSimpleDrag();
        Assert.assertEquals(page.getSimpleDropColor(), "#4682b4",
                "Drop Box color did not change as expected");
    }

    @Test
    public void acceptDragTest() {
        page.acceptTabClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acceptDropContainer")));
        page.setNotAcceptableDrag();
        Assert.assertNotEquals(page.getAcceptDropAttribute(), "drop-box ui-droppable ui-state-highlight");
        page.setAcceptableDrag();
        Assert.assertEquals(page.getAcceptDropAttribute(), "drop-box ui-droppable ui-state-highlight");
    }

    @Test
    public void prevenetPropogationTest() {
        page.preventPropogationTabeClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ppDropContainer")));
        page.dragToNotGreedyInnerBox();
        Assert.assertEquals(page.getNotGreedyOuterBoxText(), "Dropped!");
        page.dragToGreedyInnerBox();
        Assert.assertNotEquals(page.getGreedyOuterBoxText(), "Dropped!");
    }

    @Test
    public void revertableDragTest() {
        page.revertableTabClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revertableDropContainer")));
        int[] before = page.getRevertableDragPosition();
        page.setRevertableDrag();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int[] after = page.getRevertableDragPosition();
        Assert.assertEquals(before, after);

        int[] before2 = page.getNotRevertableDragPosition();
        page.setNotRevertableDrag();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int[] after2 = page.getNotRevertableDragPosition();
        Assert.assertNotEquals(before2, after2);
    }
}