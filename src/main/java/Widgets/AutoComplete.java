package Widgets;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoComplete {
    WebDriver driver;

    @FindBy(id = "autoCompleteMultipleInput")
    WebElement multipleColor;

    @FindBy(id = "autoCompleteSingleInput")
    WebElement singleColor;

    @FindBy(id = "autoCompleteMultipleContainer")
    WebElement multipleColorContainer;

    @FindBy(id = "autoCompleteSingleContainer")
    WebElement singleColorContainer;

    public AutoComplete (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void multipleColorInput(String color){
        multipleColor.sendKeys(color);
        multipleColor.sendKeys(Keys.ENTER);
    }

    public void singleColorInput(String color){
        singleColor.sendKeys(color);
        singleColor.sendKeys(Keys.ENTER);
    }

    public String multipleColorContainerText(){
        return multipleColorContainer.getText();
    }

    public String singleColorContainerText(){
        return singleColorContainer.getText();
    }

}
