package Elements.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton {
    WebDriver driver;

    public RadioButton(WebDriver driver){
        this.driver = driver;
    }

    public void clickYes(){
        WebElement yesRadio = driver.findElement(By.id("yesRadio"));
        yesRadio.click();
    }

    public void clickImpressive(){
        WebElement impressiveRadio = driver.findElement(By.id("impressiveRadio"));
        impressiveRadio.click();
    }
}