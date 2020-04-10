package com.qa.pom.pages;

import com.qa.pom.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//div[text()='Contacts']")
    private WebElement contactInfo;

    @FindBy(xpath = "//button[text()='New']")
    WebElement newContact;

    @FindBy(name = "first_name")
    WebElement firstname;

    @FindBy(name = "last_name")
    WebElement lastName;

    @FindBy(name = "company")
    WebElement companyName;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement saveButton;

    /* This method is not useful because it is particularly click on Niket Kothari checkbox
    @FindBy(xpath = "//td[text()='Niket Kothari']//preceding-sibling::td")
    WebElement checkBox;

     */

    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }

    public Boolean verifyContactsLabel() {
        return contactInfo.isDisplayed();
    }

    public void selectContactsByName(String contactName) {
        driver.findElement(By.xpath("//td[text()='" + contactName + "']//preceding-sibling::td")).click();
    }

    public void clickOnNewContactLink() {
        newContact.click();
    }

    public void createNewContact(String fN, String lN) {
        firstname.sendKeys(fN);
        lastName.sendKeys(lN);
        saveButton.click();
    }
}
