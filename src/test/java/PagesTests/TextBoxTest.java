package PagesTests;

import Pages.TextBoxPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TextBoxTest {
    WebDriver driver;
    TextBoxPage page;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        page = new TextBoxPage(driver);
    }

    @Test
    public void textBoxTest(){
        page.enterEmail("123@123.123");
        page.clickSubmit();
        Assert.assertTrue(driver.getPageSource().contains("123@123.123"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}