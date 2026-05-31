package Widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accordion {
    WebDriver driver;

    @FindBy(xpath = "//button[text() = 'What is Lorem Ipsum?']")
    WebElement accordion1;

    @FindBy(xpath = "//button[text() = 'Where does it come from?']")
    WebElement accordion2;

    @FindBy(xpath = "//button[text() = 'Why do we use it?']")
    WebElement accordion3;

    @FindBy(xpath = "//div[@class = 'accordion-item'][.//button[text() = 'What is Lorem Ipsum?']]" +
            "//div[@class = 'accordion-body']")
    WebElement accordion1Text;

    @FindBy(xpath = "//div[@class = 'accordion-item'][.//button[text() = 'Where does it come from?']]" +
            "//div[@class = 'accordion-body']")
    WebElement accordion2Text;

    @FindBy (xpath = "//div[@class = 'accordion-item'][.//button[text() = 'Why do we use it?']]" +
            "//div[@class = 'accordion-body']")
    WebElement accordion3Text;

    public Accordion(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void accordion1Click(){
        accordion1.click();
    }

    public void accordion2Click(){
        accordion2.click();
    }

    public void accordion3Click(){
        accordion3.click();
    }

    public String getAccordion1Text(){
        return accordion1Text.getText();
    }

    public String getAccordion2Text(){
        return accordion2Text.getText();
    }

    public String getAccordion3Text(){
        return accordion3Text.getText();
    }

}
