package WidgetsTests;

import Base.BaseTest;
import Widgets.SelectMenu;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTest extends BaseTest {
    SelectMenu page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/select-menu");
        page = new SelectMenu(driver);
    }

    @Test
    public void selectMenuTest(){
        page.selectOption();
        Assert.assertTrue(page.getOptionFieldText().contains("Another root option"));
        page.selectCars();
    }
}
