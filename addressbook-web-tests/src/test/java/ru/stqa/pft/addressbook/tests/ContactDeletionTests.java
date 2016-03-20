package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().goHome();
    if (app.contact().all().size() == 0) {
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

    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().goHome();
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() - 1);

    assertThat(after, equalTo(before.without(deletedContact)));
  }



}
