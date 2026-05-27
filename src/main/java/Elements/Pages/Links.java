package Elements.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Links {
    WebDriver driver;

    @FindBy(id = "created")
    WebElement created;

    public Links(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreated(){
        created.click();
    }

    public String getStatusText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement response = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse")));
        return response.getText();
    }
}