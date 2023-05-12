package com.orangehrmautomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployee{
    WebDriver driver;

    public AddEmployee(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()='PIM']")
    WebElement lkPIM;

    @FindBy(xpath = "//a[text()='Add Employee']")
    WebElement lkAddEmployee;

    @FindBy(xpath = "//input[@class='oxd-file-input']")
    WebElement btnUploadProfile;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='middleName']")
    WebElement middleName;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSave;


    public void uploadProfileImage(String profile){
        btnUploadProfile.sendKeys(profile);
    }
    public void setFirstName(String fname){
        firstName.sendKeys(fname);
    }

    public void setMiddleName(String mname){
        middleName.sendKeys(mname);

    }
    public void setLastName(String lname){
        lastName.sendKeys(lname);
    }

    public void clickOnSave(){
        btnSave.click();
    }

    public void goTOPIM(){
        lkPIM.click();
    }
    public void clickOnAddEmployee(){
        lkAddEmployee.click();
    }


}
