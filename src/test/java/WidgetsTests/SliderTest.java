package WidgetsTests;

import Base.BaseTest;
import Widgets.Slider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTest extends BaseTest {
    Slider page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/slider");
        page = new Slider(driver);
    }

    @Test
    public void sliderTest(){
        String before = page.getSliderValue();
        page.moveSlider();
        String after = page.getSliderValue();
        Assert.assertNotEquals(before,after);
    }
}