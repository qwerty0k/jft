package ru.stqa.jft.addressbook.appmanager;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.jft.addressbook.model.ContactData;
import ru.stqa.jft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }
    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getTittle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("work"), contactData.getWork());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("homepage"), contactData.getHomepage());

        // new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());

        type(By.name("address2"), contactData.getAddress2());
        type(By.name("phone2"), contactData.getPhone2());
        type(By.name("notes"), contactData.getNotes());
    }
    public void submitContactCreation() {
        click(By.name("submit"));
    }
    public void returnHomePage() {
        click(By.linkText("home"));
    }
    public void deleteSelectedContacts() {
        click(By.cssSelector(".left:nth-child(8) > input"));
        driver.switchTo().alert().accept();
    }
    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }
    public void returnToHomePage() {
        click(By.linkText("home"));
    }

   public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("tr"));
        elements.remove(0);
        for (WebElement element : elements) {
            String text = element.getText();
            String[] LastNameAndFirstName = text.split("\\s+");
            String lastName = LastNameAndFirstName[0];
            String firstName = LastNameAndFirstName[1];
            ContactData contact = new ContactData(firstName, null, lastName);
            contacts.add(contact);
        }
        return contacts;
    }
}
