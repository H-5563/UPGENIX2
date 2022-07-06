package com.upgenix.pages;

import com.upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(name="login")
    public WebElement usernameBox;
    @FindBy(name="password")
    public WebElement passwordBox;
    @FindBy(xpath="//button[@class='btn btn-primary']")
    public WebElement loginButton;

    @FindBy(xpath="//a[@class='btn btn-link pull-right']")
    public WebElement resetPasswordButton;

    @FindBy(xpath="//p[contains(@class,'alert alert-danger')]")
    public WebElement errormessage;
    @FindBy(xpath="//input[@type='password']")
    public WebElement bulletPasswordVerify;

}
