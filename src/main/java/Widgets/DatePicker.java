package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DatePicker {
    WebDriver driver;

    @FindBy (id = "datePickerMonthYearInput")
    WebElement date;

    @FindBy(id = "dateAndTimePickerInput")
    WebElement dateAndTime;

    public DatePicker (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setDate(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        date.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month-container")));

        new Select(driver.findElement(By.className("react-datepicker__year-select")))
                .selectByVisibleText("2001");
        new Select(driver.findElement(By.className("react-datepicker__month-select")))
                .selectByVisibleText("January");
        driver.findElement(By.xpath("//div[not (contains(@class, 'outside-month'))" +
                " and text()='1']")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("react-datepicker__month-container")));
    }

    public void setDateAndTime(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        dateAndTime.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker-popper")));

        driver.findElement(By.cssSelector(".react-datepicker__year-read-view--selected-year")).click();
        driver.findElement(By.xpath("//div[@class = 'react-datepicker__year-option' and text() = '2025']"))
                .click();
        driver.findElement(By.cssSelector(".react-datepicker__month-read-view--selected-month")).click();
        driver.findElement(By.xpath("//div[@class = 'react-datepicker__month-option' and text() = 'October']"))
                        .click();
        driver.findElement(By.xpath("//div[not(contains(@class, 'outside-month')) and text() = '4']"))
                .click();
        driver.findElement(By.xpath("//li[text() = '12:30']")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("react-datepicker-popper")));
    }

    public String getDateText(){
        return date.getAttribute("value");
    }

    public String getDateAndTimeText(){
        return dateAndTime.getAttribute("value");
    }
}
