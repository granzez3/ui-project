package InteractionsTests;

import Base.BaseTest;
import Interactions.Draggable;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DraggableTest extends BaseTest {
    Draggable page;
    WebDriverWait wait;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/dragabble");
        page = new Draggable(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void simpleDragTest(){
        page.simpleTabClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggableExample-tabpane-simple")));
        int[] before = page.simpleDragBoxPosition();
        page.dragSimpleBox();
        int[] after = page.simpleDragBoxPosition();
        Assert.assertNotEquals(before, after);
    }

    @Test
    public void axisRestrictedDragTest(){
        page.axisRestrictedTabClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "draggableExample-tabpane-axisRestriction")));
        Point beforeX = page.getXDragLocation();
        page.dragXBox();
        Point afterX = page.getXDragLocation();
        Assert.assertNotEquals(beforeX.getX(), afterX.getX());
        Assert.assertEquals(beforeX.getY(), afterX.getY());

        Point beforeY = page.getYDragLocation();
        page.dragYBox();
        Point afterY = page.getYDragLocation();
        Assert.assertEquals(beforeY.getX(), afterY.getX());
        Assert.assertNotEquals(beforeY.getY(), afterY.getY());
    }

    @Test
    public void containerRestrictedTest(){
        page.containerRestrictionTabClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "draggableExample-tabpane-containerRestriction")));
        page.dragContainedWithinBoxDragBox();
        Rectangle draggable = page.getContainedWithinBoxDragBoxRect();
        Rectangle container = page.getContainmentWrapperRect();
        Assert.assertTrue(draggable.getX() + draggable.getWidth()
                <= container.getX() + container.getWidth());
        Assert.assertTrue(draggable.getY() + draggable.getHeight()
                <= container.getY() + container.getHeight());

        page.dragContainedWithinParentDragBox();
        Rectangle draggable2 = page.getContainedWithinParentDragBoxRect();
        Rectangle container2 = page.getParentWrapperRect();
        Assert.assertTrue(draggable2.getX() + draggable2.getWidth()
                <= container2.getX() + container2.getWidth());
        Assert.assertTrue(draggable2.getY() + draggable2.getHeight()
                <= container2.getY() + container2.getHeight());
    }

    @Test
    public void cursorStyleTest(){
        page.cursorStyleTabClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggableExample-tabpane-cursorStyle")));
        page.dragCursorCenterDragBox();
        page.dragCursorTopLeftDragBox();
        page.dragCursorBottomDragBox();
    }
}