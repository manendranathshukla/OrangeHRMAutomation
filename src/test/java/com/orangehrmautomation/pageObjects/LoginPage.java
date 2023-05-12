package com.orangehrmautomation.pageObjects;

import com.orangehrmautomation.testCases.Base;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.orangehrmautomation.testCases.Base;
public class LoginPage {
    WebDriver ldriver;
    public LoginPage (WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(xpath = "//input[@name='username']")
    @CacheLookup
    WebElement txtUsername;

    @FindBy(xpath = "//input[@name='password']")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(className = "orangehrm-login-button")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(xpath = "//h6")
    WebElement txtDashbord;

    @FindBy(className = "oxd-alert")
    WebElement txtError;

    @FindBy(className = "oxd-userdropdown")
    WebElement dropdownMenu;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement lkLogout;

    public void setUsername(String uname){
        txtUsername.sendKeys(uname);
    }

    public void setPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickLogin(){
        btnLogin.click();
    }
    public boolean isLoggedIn(){
        if(txtDashbord.isDisplayed()) return true;
        else return false;

    }
    public boolean isErrorDisplayed(){
        boolean isDisplayed=true;
        try {
            if (txtError.isDisplayed())
                isDisplayed=true;
        }catch (NoSuchElementException e){
            isDisplayed=false;
        }
        return isDisplayed;
    }

    public void logoutUser(){
        if(dropdownMenu.isDisplayed()){
            dropdownMenu.click();
            lkLogout.click();
        }

    }



}
