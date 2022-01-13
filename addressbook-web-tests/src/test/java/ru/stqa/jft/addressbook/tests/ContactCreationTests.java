package ru.stqa.jft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.jft.addressbook.model.ContactData;
import java.util.*;

public class ContactCreationTests extends TestBase {

    @Test(enabled = false)
    public void testContactCreation () {
        app.goTo().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("Test1", "Test2","Test3","Testik", "TestContact", "ITB", "TMoscow", "MoscowT", "Test1234899", "qatest", "testfax", "testmail", "testMail2", "testMail3", "telest", "Test1", "msk", "testmobile2", "notesTest");
        // ContactData contact = new ContactData("Test3", null, "Test4");
        app.getContactHelper().createContact(contact);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);

        Comparator<? super ContactData> byFirstName = (o1, o2) -> o1.getFirstname().compareTo(o2.getFirstname());
        Comparator<? super ContactData> byLastName = (o1, o2) -> o1.getLastname().compareTo(o2.getLastname());
        before.sort(byFirstName);
        before.sort(byLastName);
        after.sort(byFirstName);
        after.sort(byLastName);
        Assert.assertEquals(before,after);
    }
}
