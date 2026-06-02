package Widgets;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectMenu {
    WebDriver driver;
    Actions actions;

    @FindBy (id = "react-select-2-input")
    WebElement option;

    @FindBy (xpath = "//div[@class = 'css-1dimb5e-singleValue']")
    WebElement optionField;

    @FindBy (xpath = "//option[@value = 'volvo']")
    WebElement volvo;

    @FindBy (xpath = "//option[@value = 'audi']")
    WebElement audi;

    public SelectMenu(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public void selectOption(){
        option.click();
        option.sendKeys(Keys.ARROW_UP);
        option.sendKeys(Keys.ENTER);
    }
    public String getOptionFieldText(){
        return optionField.getText();
    }

    public void selectCars(){
        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        audi
                );

        actions.keyDown(Keys.CONTROL)
                .click(audi)
                .click(volvo)
                .keyUp(Keys.CONTROL)
                .perform();
    }
}
