package com.orangehrmautomation.testCases;

import com.orangehrmautomation.pageObjects.LoginPage;
import com.orangehrmautomation.utilities.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.orangehrmautomation.utilities.XLUtils.*;

public class TC_LoginTestTDD_002 extends Base{

    @Test(dataProvider = "LoginData")
    public void loginDDT(String user,String pwd) throws InterruptedException, IOException {
        LoginPage lp = new LoginPage(driver);
        lp.setUsername(user);
        lp.setPassword(pwd);
        lp.clickLogin();
        if(lp.isErrorDisplayed()){
            captureScreen(driver,"loginTest");
            Assert.assertTrue(false);
            logger.warning("Login failed");
        }else{
            Assert.assertTrue(true);
            logger.info("Login passed");
            lp.logoutUser();
            Thread.sleep(3000);


        }


    }


    @DataProvider(name="LoginData")
    String[][] getData() throws IOException{

        String path= System.getProperty("user.dir")+"/src/test/java/com/orangehrmautomation/testData/LoginData.xlsx";
        int rownum  = getRowCount(path,"Sheet1");
        int colnum=getCellCount(path,"Sheet1",1);
        String logindata[][] = new String[rownum][colnum];
        for(int i=1;i<=rownum;i++){
            for(int j =0;j<colnum;j++){
                logindata[i-1][j]=getCellData(path,"Sheet1",i,j);

            }
        }
        return logindata;
    }

}
