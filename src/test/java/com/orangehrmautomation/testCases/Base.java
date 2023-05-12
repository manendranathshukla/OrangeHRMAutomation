package com.orangehrmautomation.testCases;

import com.orangehrmautomation.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Base {

    ReadConfig config= new ReadConfig();
    public String baseURL=config.getApplicationUrl();
    public String username=config.getUsername();
    public String passord= config.getPassword();
    public String firstName=config.getFirstName();
    public String middleName=config.getMiddleName();
    public String lastName=config.getLastName();
    public String profile=config.getProfile();
    public static WebDriver driver;

    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br){


        logger = Logger.getLogger("orangehrm");
        PropertyConfigurator.configure("Log4j.properties");

        if(br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", config.getChromeDriverPath());
            driver = new ChromeDriver();
        }
        else if(br.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", config.getGeckoDriverPath());
            driver = new FirefoxDriver();
        }
        else if(br.equals("ie")){
            System.setProperty("webdriver.ie.driver", config.getIEDriverPath());
            driver = new InternetExplorerDriver();
        }
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();

    }

    public void captureScreen(WebDriver driver,String tname) throws IOException{
        TakesScreenshot ts= (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target= new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
        FileUtils.copyFile(source,target);
        System.out.println("Screenshot taken");
    }

}
