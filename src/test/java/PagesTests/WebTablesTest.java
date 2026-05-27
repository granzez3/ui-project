package PagesTests;

import Elements.Pages.WebTables;
import Base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTest extends BaseTest {
    WebTables page;

    @BeforeMethod
    public void initPage(){
        driver.get("https://demoqa.com/webtables");
        page = new WebTables(driver);
    }

    @Test
    public void webTablesTest(){
        page.sendData("John",
                "Doe",
                "johndoe@gmail.com",
                "32",
                "12000",
                "CyberSecurity");
    }

}