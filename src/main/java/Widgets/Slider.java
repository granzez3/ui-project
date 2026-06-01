package Widgets;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Slider {
    WebDriver driver;

    @FindBy (id = "slider")
    WebElement slider;

    @FindBy (id = "sliderValue")
    WebElement sliderValue;


    public Slider (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void moveSlider(){
        slider.sendKeys(Keys.ARROW_RIGHT);
    }

    public String getSliderValue(){
        return sliderValue.getAttribute("value");
    }
}
