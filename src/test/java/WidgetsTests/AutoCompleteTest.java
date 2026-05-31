package WidgetsTests;

import Base.BaseTest;
import Widgets.AutoComplete;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompleteTest extends BaseTest {
    AutoComplete page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/auto-complete");
        page = new AutoComplete(driver);
    }

    @Test
    public void autoCompleteTest(){
        page.multipleColorInput("R");
        Assert.assertTrue(page.multipleColorContainerText().contains("Red"));
        page.multipleColorInput("B");
        Assert.assertTrue(page.multipleColorContainerText().contains("Blue"));
        page.singleColorInput("G");
        Assert.assertTrue(page.singleColorContainerText().contains("Green"));
    }

}