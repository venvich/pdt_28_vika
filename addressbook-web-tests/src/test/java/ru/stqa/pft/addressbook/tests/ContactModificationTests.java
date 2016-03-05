package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().goHome();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("__ssss", "Firtsname2", "_Lass", "First.Last", "Dr.", "Test GmbH",
            "", "", "+1234567890", "", "", "",
            "", "", "", "www.mypage.com", "1", "February", "1985"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
}
