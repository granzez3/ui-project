package WidgetsTests;

import Base.BaseTest;
import Widgets.DatePicker;
import org.testng.Assert;
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
        page.setDate();
        page.setDateAndTime();
        Assert.assertTrue(page.getDateText().contains("01/01/2001"));
        Assert.assertTrue(page.getDateAndTimeText().contains("October 4, 2025 12:30 PM"));
    }
}