package FormsTests;

import Base.BaseTest;
import Forms.PracticeForm;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest {
    PracticeForm page;

    @BeforeMethod
    public void pageInit(){
        driver.get("https://demoqa.com/automation-practice-form");
        page = new PracticeForm(driver);
    }

    @Test
    public void PFTest(){
        page.fillRegistrationForm("John",
                "Doe",
                "johdoe@gmail.com",
                "0123456789",
                "Maths",
                "d:\\WinUsers\\User\\Pictures\\Screenshots\\Снимок экрана (1).png",
                "JohnDoe.st,93",
                "NCR",
                "Delhi");
    }
}
