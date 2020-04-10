package com.qa.pom.testcases;

import com.qa.pom.base.TestBase;
import com.qa.pom.pages.HomePage;
import com.qa.pom.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    public LoginPage loginPage;
    public HomePage homePage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loginIn(property.getProperty("username"), property.getProperty("password"));
    }

    @Test(priority = 1)
    public void verfifyHomePageTitleTest() {
       String title = homePage.verifyHomePageTitle();
       Assert.assertEquals(title, "Cogmento CRM", "Home Page title not matched");
    }

    @Test(priority = 2)
    public void verifyUserNameTest() {
        Assert.assertTrue(homePage.verifyUserName());
    }

    @Test(priority = 3)
    public void verifyContactsLinkTest() {
        /* Here just we are clicking on contacts link so it's not require to store reference of contact page bcs
         further we are not performing any extra steps on Contact page
          * But we are not checking anything to check whether my test case is passing or not
          * or whether i am landing on correct page or not
          */
        homePage.clickOnContactsLink();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
