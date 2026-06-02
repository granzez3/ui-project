package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Menu {
    WebDriver driver;
    Actions actions;

    @FindBy(xpath = "//a[text()='Main Item 1']")
    WebElement mainItem1;

    @FindBy(xpath = "//a[text()='Main Item 2']")
    WebElement mainItem2;

    @FindBy(xpath = "//*[@id='nav']/li[2]/ul/li[1]")
    WebElement subItem1;

    @FindBy(xpath = "//*[@id='nav']/li[2]/ul/li[2]")
    WebElement subItem2;

    @FindBy(xpath = "//*[@id='nav']/li[2]/ul/li[3]")
    WebElement subSubList;

    @FindBy(xpath = "//*[@id='nav']/li[2]/ul/li[3]/ul/li[1]")
    WebElement subSubItem1;

    @FindBy(xpath = "//*[@id='nav']/li[2]/ul/li[3]/ul/li[2]")
    WebElement subSubItem2;

    @FindBy(xpath = "//a[text()='Main Item 3']")
    WebElement mainItem3;


    public Menu (WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void hoverSubSubItem2(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Main Item 2']")));
        actions.moveToElement(mainItem2).pause(Duration.ofSeconds(1)).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='nav']/li[2]/ul/li[3]")));
        actions.moveToElement(subSubList).pause(Duration.ofSeconds(1)).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='nav']/li[2]/ul/li[3]/ul/li[2]")));
        actions.moveToElement(subSubItem2).pause(Duration.ofSeconds(1)).perform();
    }
}
