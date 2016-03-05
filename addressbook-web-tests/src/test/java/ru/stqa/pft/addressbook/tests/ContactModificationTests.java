package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goHome();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Peter", "Paul", "Klee", "First.Last", "Dr.", "Test GmbH",
              "Neverstreet 1, Nevertown 123", "Neverstreet 1, Nevertown 1234",
              "+1234567890", "+41781111111", "+41312222222", "+41313333333",
              "", "", "", "www.mypage.com", "1", "January", "1980", "Test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("__ssss", "Firtsname2", "_Lass", "First.Last", "Dr.", "Test GmbH",
            "", "", "+1234567890", "", "", "",
            "", "", "", "www.mypage.com", "1", "February", "1985", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
}
