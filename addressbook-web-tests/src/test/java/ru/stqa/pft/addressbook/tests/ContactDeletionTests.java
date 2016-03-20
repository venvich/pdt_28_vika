package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().goHome();
    if (app.contact().list().size() == 0) {
      app.contact().createContact(new ContactData()
              .withFirstname("Markus")
              .withLastname("Meier")
              .withAddress("Everstreet 1, Evertown 1234")
              .withHome("+2234567890")
              .withEmail("markus.meier@gmail.com")
              .withBday("2")
              .withBmonth("January")
              .withByear("1985")
              .withNew_group("Test1"));
    }
  }

  @Test
  public void testContactDeletion() {

    List<ContactData> before = app.contact().list();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().goHome();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }



}
