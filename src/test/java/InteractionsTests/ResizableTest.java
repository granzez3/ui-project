package InteractionsTests;

import Base.BaseTest;
import Interactions.Resizable;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ResizableTest extends BaseTest {
    Resizable page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/resizable");
        page = new Resizable(driver);
    }

    @Test
    public void resizableTest(){
        page.moveRestrictedDrag();
        Assert.assertTrue(Arrays.toString(page.sizeOfResizableBoxWithRestriction()).contains("[300, 300]"));
        page.moveUnrestrictedDrag();
        Assert.assertTrue(Arrays.toString(page.sizeOfResizableBox()).contains("[500, 200]"));
    }
}
