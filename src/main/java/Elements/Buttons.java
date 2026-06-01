package Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buttons {
    WebDriver driver;
    Actions actions;

    @FindBy(xpath = "//button[text() = 'Double Click Me']")
    WebElement doubleClick;

    @FindBy(xpath = "//button[text() = 'Right Click Me']")
    WebElement rightClick;

    @FindBy(xpath = "//button[text() = 'Click Me']")
    WebElement dynamicClick;

    public Buttons(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public void clicks(){
        actions.moveToElement(doubleClick).doubleClick(doubleClick).perform();
        actions.contextClick(rightClick).perform();
        dynamicClick.click();
    }

    //@FindBy(xpath = "(//button[text()='Click Me'])[3]")
}