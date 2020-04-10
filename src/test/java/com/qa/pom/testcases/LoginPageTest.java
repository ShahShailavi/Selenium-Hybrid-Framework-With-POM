package com.qa.pom.testcases;

import com.qa.pom.base.TestBase;
import com.qa.pom.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    public LoginPage loginPage;


    public LoginPageTest() {

        super();

    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Cogmento CRM");
    }

    @Test(priority = 2)
    public void loginIntoFreeCRMTest() {
        String username = property.getProperty("username");
        String password = property.getProperty("password");
        loginPage.loginIn(username, password);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
