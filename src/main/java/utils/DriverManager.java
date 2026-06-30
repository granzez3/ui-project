package utils;

import config.ConfigReader;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager(){}

    public static WebDriver getDriver(){
        if(driver == null){
            String browser = ConfigReader.getProperty("browser");

            driver = DriverFactory.createDriver(browser);

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driver;
    }

    public static void quitDriver(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}