package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {
    
    @Test
    public void testContactCreation() {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("_Firstname", "Firtsname2", "_Lastname", "First.Last", "Dr.", "Test GmbH",
                "Neverstreet 1, Nevertown 123", "Neverstreet 1, Nevertown 1234",
                "+1234567890", "+41781111111", "+41312222222", "+41313333333",
                "", "", "", "www.mypage.com", "1", "January", "1980"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().gotoHomePage();
    }





}
