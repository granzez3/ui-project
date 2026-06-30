package ElementsTests;

import Elements.Buttons;
import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {
    Buttons page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/buttons");
        page = new Buttons(driver);
    }

    @Test
    public void buttonsTest(){
        page.clicks();

        Assert.assertTrue(driver.getPageSource().contains("You have done a double click"));
        Assert.assertTrue(driver.getPageSource().contains("You have done a right click"));
        Assert.assertTrue(driver.getPageSource().contains("You have done a dynamic click"));
    }
}
