package Elements.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicProperties {
    WebDriver driver;

    @FindBy(id = "visibleAfter")
    WebElement visible;

    @FindBy(id = "enableAfter")
    WebElement enable;

    @FindBy(id = "colorChange")
    WebElement color;

    public DynamicProperties(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void visibleClick(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement visible = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        visible.click();
    }

    public void enableCLick(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement clickable = wait.until(ExpectedConditions.elementToBeClickable(enable));
        clickable.click();
    }

    public String colorGet(){
        WebElement colorChange = driver.findElement(By.id("colorChange"));
        return Color.fromString(colorChange.getCssValue("color")).asHex();
    }
}