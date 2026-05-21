import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    WebDriver driver;

    public Main(WebDriver driver){
        this.driver = driver;
    }

    public void clickSubmitButton(){
        WebElement submit = driver.findElement(By.id("submit"));
    }
}
