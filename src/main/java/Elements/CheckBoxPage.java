package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage {
    WebDriver driver;

    public CheckBoxPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickTreeOpener(){
        WebElement treeOpener = driver.findElement(By.cssSelector("span[class=\"rc-tree-switcher rc-tree-switcher_close\"] "));
        treeOpener.click();
    }

    public void clickHomeButton(){
        WebElement homeButton = driver.findElement(By.cssSelector("span[aria-label = 'Select Home']"));
        homeButton.click();
    }

}