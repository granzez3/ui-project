package PagesTests;

import Pages.DynamicProperties;
import PagesTests.Base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicPropertiesTest extends BaseTest {
    DynamicProperties page;

    @BeforeMethod
    public void initPage(){
        driver.get("https://demoqa.com/dynamic-properties");
        page = new DynamicProperties(driver);
    }

    @Test
    public void DPTest(){
        page.visibleClick();
    }
}
