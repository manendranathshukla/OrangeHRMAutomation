package com.orangehrmautomation.testCases;

import com.orangehrmautomation.pageObjects.AddEmployee;
import com.orangehrmautomation.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_AddEmployeeTest_003 extends Base{



    @Test
    public void addEmployeeTest(){
        logger.info("Url opened");
        LoginPage lp= new LoginPage(driver);
        AddEmployee ae= new AddEmployee(driver);
        lp.setUsername(username);
        logger.info("Entered username");
        lp.setPassword(passord);
        logger.info("Entered password");
        lp.clickLogin();
        if(lp.isLoggedIn()) {
            Assert.assertTrue(lp.isLoggedIn());
            logger.info("Login test passed");
            ae.goTOPIM();
            ae.clickOnAddEmployee();
            logger.info("Add Employee page opened");
            ae.uploadProfileImage(profile);
            ae.setFirstName(firstName);
            ae.setMiddleName(middleName);
            ae.setLastName(lastName);
            ae.clickOnSave();




        }else{
//            captureScreen(driver,"loginTest");
            Assert.assertTrue(false);
            logger.info("Login test failed");

        }
    }

}
