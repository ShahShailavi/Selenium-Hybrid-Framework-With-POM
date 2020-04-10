package com.qa.pom.pages;

import com.qa.pom.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page - Factory
    @FindBy(name = "email")
    private WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//div[text()='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//a[text()='Sign Up']")
    WebElement signUpLink;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions
    public static String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public HomePage loginIn(String userName, String passWord) {
        username.sendKeys(userName);
        password.sendKeys(passWord);
        loginButton.click();

        return new HomePage();
    }

}
