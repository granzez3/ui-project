package Interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Selectable {
    WebDriver driver;

    @FindBy (xpath = "//li[text() ='Cras justo odio']")
    WebElement firstTextList;

    @FindBy (xpath = "//div[@id = 'gridContainer']//li[text()='Five']")
    WebElement fiveGrid;

    public Selectable (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void firstTextListClick(){
        firstTextList.click();
    }

    public String listBackgroundColorGet(){
        return Color.fromString(firstTextList.getCssValue("background-color")).asHex();
    }
}
