package InteractionsTests;

import Base.BaseTest;
import Interactions.Selectable;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectableTest extends BaseTest {
    Selectable page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/selectable");
        page = new Selectable(driver);
    }

    @Test
    public void selectableTest(){
        page.firstTextListClick();
        Assert.assertEquals(page.listBackgroundColorGet(), "#0d6efd");
    }
}