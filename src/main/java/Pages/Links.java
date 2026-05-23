package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Links {
    WebDriver driver;

    @FindBy(id = "created")
    WebElement created;

    @FindBy(id = "no-content")
    WebElement noContent;

    @FindBy(id = "moved")
    WebElement moved;

    @FindBy(id = "bad-request")
    WebElement badRequest;

    @FindBy(id = "unauthorized")
    WebElement unauthorized;

    @FindBy(id = "forbidden")
    WebElement forbidden;

    @FindBy(id = "not-found")
    WebElement notFound;

    @FindBy(xpath = "//b[1]")
    WebElement status;

    @FindBy(xpath = "//b[2]")
    WebElement statusText;

    public Links(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreated(){
        created.click();
    }
}
