package com.orangehrmautomation.testCases;

import com.orangehrmautomation.pageObjects.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends Base {


    @Test
    public void loginTest() throws IOException {


        logger.info("Url is opened");
        LoginPage lp= new LoginPage(driver);
        lp.setUsername(username);
        logger.info("Entered username");
        lp.setPassword(passord);
        logger.info("Entered password");
        lp.clickLogin();
        if(lp.isLoggedIn()) {
            Assert.assertTrue(lp.isLoggedIn());
            logger.info("Login test passed");
        }else{
            captureScreen(driver,"loginTest");
            Assert.assertTrue(false);
            logger.info("Login test failed");

        }

    }


}
