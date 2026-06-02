package WidgetsTests;

import Base.BaseTest;
import Widgets.Menu;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest {
    Menu page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/menu");
        page = new Menu(driver);
    }

    @Test
    public void menuTest(){
        //wait for elements to be stable
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        page.hoverSubSubItem2();

    }
}
