package PagesTests;

import Pages.Links;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTest extends BaseTest {
    Links page;

    @BeforeMethod
    public void initPage(){
        driver.get("https://demoqa.com/links");
        page = new Links(driver);
    }

    @Test
    public void linksTest(){
        page.clickCreated();
        Assert.assertTrue(driver.getPageSource().contains("201"));
        Assert.assertTrue(driver.getPageSource().contains("Created"));
    }
}
