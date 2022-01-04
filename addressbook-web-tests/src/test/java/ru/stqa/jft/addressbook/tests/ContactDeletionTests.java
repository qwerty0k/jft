package ru.stqa.jft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.jft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion () {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Test1", "Test2","Test3","Testik", "TestContact", "ITB", "TMoscow", "MoscowT", "Test1234899", "qatest", "testfax", "testmail", "testMail2", "testMail3", "telest", "Test1", "msk", "testmobile2", "notesTest"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
    }
}
