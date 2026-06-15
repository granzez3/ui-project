package BookStoreApplicationTests;

import Base.BaseTest;
import BookStoreApplication.Login;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {
    Login page;
    WebDriverWait wait;
    Alert alert;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/login");
        page = new Login(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Test (priority = 1)
    public void unsuccessfulRegistrationTest(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        page.newUserButtonClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("register")));
        page.userRegistration("John",
                "Doe",
                "JohnDoe5",
                "Qwerty123!?");
        page.registerButtonClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));
        switch (page.getNotificationText()){
            case "Please verify reCaptcha to register!":
                System.out.println("Please verify reCaptcha to register!");
                break;

            case "Passwords must have at least one non alphanumeric character, " +
                         "one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), " +
                         "one special character and Password must be eight characters or longer.":
                System.out.println("Enter right new password!");
                break;
            case "User exists!":
                System.out.println("User exists!");
                break;
        }
    }

    @Test (priority = 2)
    public void successfulRegistrationTest(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        page.newUserButtonClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("register")));
        String uniqueUserName = "JohnDoe" + System.currentTimeMillis();
        page.userRegistration("John",
                "Doe",
                uniqueUserName,
                "Qwerty123!?");
        page.registerButtonClick();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alert.accept();
        page.gotologinButtonClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        page.userLogin(uniqueUserName, "Qwerty123!?");
        page.loginButtonClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("profile-wrapper")));
    }
}
