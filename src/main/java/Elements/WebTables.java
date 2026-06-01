package Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTables {
    WebDriver driver;

    @FindBy(id = "addNewRecordButton")
    WebElement add;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "age")
    WebElement age;

    @FindBy(id = "salary")
    WebElement salary;

    @FindBy(id = "department")
    WebElement department;

    @FindBy(id = "submit")
    WebElement submit;

    public WebTables(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void sendData(String userFirstName,
                         String userLastName,
                         String email,
                         String userAge,
                         String userSalary,
                         String userDepartment){
        add.click();
        firstName.sendKeys(userFirstName);
        lastName.sendKeys(userLastName);
        userEmail.sendKeys(email);
        age.sendKeys(userAge);
        salary.sendKeys(userSalary);
        department.sendKeys(userDepartment);
        submit.click();
    }
}