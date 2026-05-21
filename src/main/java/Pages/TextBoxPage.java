package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {
    WebDriver driver;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "submit")
    WebElement submitButton;

    public TextBoxPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email){
        userEmail.sendKeys(email);
    }

    public void clickSubmit(){
        submitButton.click();
    }
}
