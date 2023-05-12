package com.orangehrmautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties pro;
    public ReadConfig(){
        File src= new File("./Configuration/config.properties");
        try{
            FileInputStream fis= new FileInputStream(src);
            pro=new Properties();
            pro.load(fis);
        }catch (Exception e){
            System.out.println("Exception is "+e.getMessage());
        }
    }

    public String getApplicationUrl(){
        return pro.getProperty("baseURL");
    }

    public String getUsername(){
        return pro.getProperty("username");
    }

    public String getFirstName() {
        return pro.getProperty("firstName");
    }

    public String getMiddleName() {
        return pro.getProperty("middleName");
    }

    public String getLastName() {
        return pro.getProperty("lastName");
    }
    public String getPassword(){
        return pro.getProperty("password");
    }

    public String getProfile(){
        return pro.getProperty("profile");
    }

    public String getChromeDriverPath(){
        return pro.getProperty("chromepath");
    }

    public String getGeckoDriverPath(){
        return pro.getProperty("geckopath");
    }
    public String getIEDriverPath(){
        return pro.getProperty("iepath");
    }
}
