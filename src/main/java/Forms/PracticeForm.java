package Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PracticeForm {
    WebDriver driver;

    @FindBy(id = "firstName")
    WebElement userFirstName;

    @FindBy(id = "lastName")
    WebElement userLastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "gender-radio-1")
    WebElement userMaleGender;

    @FindBy(id = "userNumber")
    WebElement userNumber;

    @FindBy(id = "subjectsInput")
    WebElement userSubjectsContainer;

    @FindBy (id = "hobbies-checkbox-1")
    WebElement userHobby;

    @FindBy (id = "uploadPicture")
    WebElement upload;

    @FindBy (id = "currentAddress")
    WebElement userAddress;

    @FindBy (id = "dateOfBirthInput")
    WebElement userDateBirth;

    @FindBy(id = "react-select-3-input")
    WebElement state;

    public PracticeForm(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void fillRegistrationForm(String firstName,
                                     String lastName,
                                     String email,
                                     String number,
                                     String subjectsContainer,
                                     String path,
                                     String Address,
                                     String State,
                                     String City){
        userFirstName.sendKeys(firstName);
        userLastName.sendKeys(lastName);
        userEmail.sendKeys(email);
        userMaleGender.click();
        userNumber.sendKeys(number);
        userDateBirth.click();
        new Select(driver.findElement(By.className("react-datepicker__year-select")))
                .selectByVisibleText("2001");
        new Select(driver.findElement(By.className("react-datepicker__month-select")))
                .selectByVisibleText("June");
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__month')]"
                + "//div[not(contains(@class,'outside-month')) and text()='3']")).click();
        userSubjectsContainer.click();
        userSubjectsContainer.sendKeys(subjectsContainer);
        userSubjectsContainer.sendKeys(Keys.ENTER);
        userHobby.click();
        upload.sendKeys(path);
        userAddress.sendKeys(Address);
        state.sendKeys(State);
        state.sendKeys(Keys.ENTER);
        driver.findElement(By.id("react-select-4-input")).sendKeys(City);
        driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("submit")).click();
    }
}
