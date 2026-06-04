package InteractionsTests;

import Base.BaseTest;
import Interactions.Sortable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SortableTest extends BaseTest {
    Sortable page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/sortable");
        page = new Sortable(driver);
    }

    @Test
    public void sortableTest(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        page.dragOneList();
        page.dragTwoList();
        Assert.assertTrue(page.getListText().contains("Three Two One Four Five Six"));

        page.gridClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo-tabpane-grid")));
        page.dragOneGrid();
        page.dragTwoGrid();
        Assert.assertTrue(page.getGridText().contains("Three Four Five One Six Seven Eight Nine Two"));
    }
}
