package WidgetsTests;

import Base.BaseTest;
import Widgets.DatePicker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePickerTest extends BaseTest {
    DatePicker page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/date-picker");
        page = new DatePicker(driver);
    }

    @Test
    public void datePickerTest(){

    }
}