package BookStoreApplication;

import org.openqa.selenium.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    @FindBy (id = "newUser")
    WebElement newUserButton;

    @FindBy(id = "firstname")
    WebElement firstnameInput;

    @FindBy(id = "lastname")
    WebElement lastnameInput;

    @FindBy(id = "userName")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "register")
    WebElement registerButton;

    @FindBy(id = "gotologin")
    WebElement gotologinButton;

    @FindBy(xpath = "//*[@id='output']")
    WebElement notificationText;

    @FindBy (id = "login")
    WebElement loginButton;

    public Login (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void newUserButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(newUserButton)).click();
    }

    public void userRegistration(String firstname,
                                   String lastname,
                                   String userName,
                                   String password){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        firstnameInput.sendKeys(firstname);
        lastnameInput.sendKeys(lastname);
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
    }

    public void registerButtonClick(){
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'})", registerButton);
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    public void gotologinButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(gotologinButton)).click();
    }

    public String getNotificationText(){
        wait.until(ExpectedConditions.visibilityOf(notificationText));
        return notificationText.getText();
    }

    public void userLogin(String userName,
                          String password){
        wait.until(ExpectedConditions.visibilityOf(userNameInput)).sendKeys(userName);
        passwordInput.sendKeys(password);
    }

    public void loginButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
}
