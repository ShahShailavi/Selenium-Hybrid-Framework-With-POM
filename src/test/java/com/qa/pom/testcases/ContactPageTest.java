package com.qa.pom.testcases;

import com.qa.pom.base.TestBase;
import com.qa.pom.pages.ContactsPage;
import com.qa.pom.pages.HomePage;
import com.qa.pom.pages.LoginPage;
import com.qa.pom.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    public String sheetName = "Contacts";

    public ContactPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loginIn(property.getProperty("username"), property.getProperty("password"));
        contactsPage = homePage.clickOnContactsLink();
    }

    @Test(priority = 1)
    public void  verifyContactsPageLabel() {
        Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label missing on the page");
    }

    @Test(priority = 2)
    public void selectContacts() throws InterruptedException {
        contactsPage.selectContactsByName("Niket  Kothari");
        Thread.sleep(2000);
    }

    @DataProvider
    public Object[][] getCRMData() {
        Object[][] data = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 3, dataProvider = "getCRMData()")
    public void validateCreateNewContact(String firstname, String lastname) {
        contactsPage.clickOnNewContactLink();
        //contactsPage.createNewContact("Shailavi", "Shah");
        contactsPage.createNewContact(firstname, lastname);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
