package com.qa.pom.pages;

import com.qa.pom.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//span[text()='Shailavi Shah']")
    WebElement user;

    @FindBy(xpath = "//span[text()='Contacts']")
    WebElement contactsLink;

    @FindBy(xpath = "//span[text()='Deals']")
    WebElement dealsLink;

    @FindBy(xpath = "//span[text()='Tasks']")
    WebElement tasksLink;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public Boolean verifyUserName() {
        return user.isDisplayed();
    }

    public ContactsPage clickOnContactsLink() {
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink() {
        dealsLink.click();
        return new DealsPage();
    }

    public TaskPage clickOnTaskLink() {
        tasksLink.click();
        return new TaskPage();
    }

}
