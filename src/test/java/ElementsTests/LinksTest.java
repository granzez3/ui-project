package ElementsTests;

import Elements.Links;
import Base.BaseTest;
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
        Assert.assertTrue(page.getStatusText().contains("201"));
        Assert.assertTrue(page.getStatusText().contains("Created"));
    }
}
