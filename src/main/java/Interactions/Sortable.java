package Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Sortable {
    WebDriver driver;
    Actions actions;

    @FindBy (xpath = "//div[@id = 'demo-tabpane-list']//div[text() = 'One']")
    WebElement oneList;

    @FindBy (xpath = "//div[@id = 'demo-tabpane-list']//div[text() = 'Two']")
    WebElement twoList;

    @FindBy (id = "demo-tab-grid")
    WebElement grid;

    @FindBy (xpath = "//div[@id = 'demo-tabpane-grid']//div[text() = 'One']")
    WebElement oneGrid;

    @FindBy (xpath = "//div[@id = 'demo-tabpane-grid']//div[text() = 'Two']")
    WebElement twoGrid;

    public Sortable(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void dragOneList(){
        actions.moveToElement(oneList)
                .clickAndHold(oneList)
                .pause(Duration.ofMillis(300))
                .moveByOffset(0,100)
                .release()
                .perform();
    }

    public void dragTwoList(){
        actions.moveToElement(twoList)
                .clickAndHold(twoList)
                .pause(Duration.ofMillis(300))
                .moveByOffset(0,50)
                .release()
                .perform();
    }

    public String getListText(){
        return driver.findElement(By.id("demo-tabpane-list")).getText().replace("\n"," ");
    }

    public void gridClick(){
        grid.click();
    }

    public void dragOneGrid(){
        actions.moveToElement(oneGrid)
                .clickAndHold(oneGrid)
                .pause(Duration.ofMillis(300))
                .moveByOffset(100,100)
                .release()
                .perform();
    }

    public void dragTwoGrid(){
        actions.moveToElement(twoGrid)
                .clickAndHold(twoGrid)
                .pause(Duration.ofMillis(300))
                .moveByOffset(200,200)
                .release()
                .perform();
    }

    public String getGridText(){
        return driver.findElement(By.id("demo-tabpane-grid")).getText().replace("\n"," ");
    }
}
