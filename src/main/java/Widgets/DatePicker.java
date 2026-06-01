package Widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DatePicker {
    WebDriver driver;

    public DatePicker (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
