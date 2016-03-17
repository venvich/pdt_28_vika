package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().goHome();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Peter", "Paul", "Klee", "First.Last", "Dr.", "Test GmbH",
              "Neverstreet 1, Nevertown 123", "Neverstreet 1, Nevertown 1234",
              "+1234567890", "", "", "",
              "", "", "", "www.mypage.com", "1", "January", "1980", "Test1"));
    }
  }

  @Test
  public void testContactDeletion() {

    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    app.getContactHelper().selectContact(index);
    app.getContactHelper().initContactModification(index);
    app.getContactHelper().submitContactDeletion();
    app.getNavigationHelper().goHome();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), index);

    before.remove(index);
    Assert.assertEquals(before, after);
  }



}
