package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ToolTips {
    WebDriver driver;

    Actions actions;

    @FindBy(id = "toolTipButton")
    WebElement button;

    @FindBy(id = "toolTipTextField")
    WebElement textField;

    @FindBy(xpath = "//a[text() = 'Contrary']")
    WebElement contrary;

    @FindBy(xpath = "//a[text() = '1.10.32']")
    WebElement numbers;

    public ToolTips (WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver ,this);
    }

    public void hoverButton(){
        button.click();
        actions.moveToElement(button).pause(Duration.ofSeconds(3)).perform();
    }

    public void hoverTextField(){
        actions.moveToElement(textField).pause(Duration.ofSeconds(3)).perform();
    }

    public void hoverContrary(){
        actions.moveToElement(contrary).pause(Duration.ofSeconds(3)).perform();
    }

    public void hoverNumbers(){
        actions.moveToElement(numbers).pause(Duration.ofSeconds(3)).perform();
    }
}
