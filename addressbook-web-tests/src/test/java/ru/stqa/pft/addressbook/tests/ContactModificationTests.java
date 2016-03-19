package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().goHome();
    if (app.contact().list().size() == 0) {
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
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData()
            .withId(before.get(index).getId())
            .withFirstname("Anna")
            .withLastname("Frei")
            .withAddress("Everstreet 1, Evertown 1234")
            .withHome("+2234567890")
            .withEmail("anna.frei@gmail.com")
            .withBday("10")
            .withBmonth("February")
            .withByear("1978")
            .withNew_group("Test1");
    app.contact().modify(before, index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
