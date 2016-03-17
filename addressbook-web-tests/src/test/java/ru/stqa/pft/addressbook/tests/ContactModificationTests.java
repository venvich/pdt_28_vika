package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().goHome();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Peter", "Paul", "Klee", "First.Last", "Dr.", "Test GmbH",
              "Neverstreet 1, Nevertown 123", "Neverstreet 1, Nevertown 1234",
              "+1234567890", "+41781111111", "+41312222222", "+41313333333",
              "", "", "", "www.mypage.com", "1", "January", "1980", "Test1"));
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    ContactData contact = new ContactData(before.get(index).getId(), "Martin", "Firtsname2", "Burger", "First.Last", "Dr.", "Test GmbH",
            "", "", "+1234567890", "", "", "",
            "", "", "", "www.mypage.com", "1", "February", "1985", null);
    app.getContactHelper().modifyContact(before, index, contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
