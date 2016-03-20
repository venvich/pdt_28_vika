package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().goHome();
    if (app.contact().all().size() == 0) {
      app.contact().createContact(new ContactData()
              .withFirstname("Pascal")
              .withLastname("Berger")
              .withAddress("Everstreet 1, Evertown 1234")
              .withHome("+2234567890")
              .withEmail("pascal.berger@gmail.com")
              .withBday("5")
              .withBmonth("February")
              .withByear("1979")
              .withNew_group("Test1"));
    }
  }

  @Test
  public void testContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstname("Anna")
            .withLastname("Frei")
            .withAddress("Everstreet 1, Evertown 1234")
            .withHome("+2234567890")
            .withEmail("anna.frei@gmail.com")
            .withBday("10")
            .withBmonth("February")
            .withByear("1978")
            .withNew_group("Test1");
    app.contact().modify(before, contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
