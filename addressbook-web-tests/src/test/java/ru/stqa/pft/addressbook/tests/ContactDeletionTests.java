package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    File photo = new File("src\\test\\resources\\614_0.jpg");
    if (app.db().contacts().size() == 0) {
      app.goTo().goHome();
      app.contact().createContact(new ContactData()
              .withFirstname("Markus")
              .withLastname("Meier")
              .withAddress("Everstreet 1, Evertown 1234")
              .withHome("+2234567890")
              .withEmail("markus.meier@gmail.com")
              .withBday("2")
              .withBmonth("January")
              .withByear("1985")
              .withPhoto(photo));
              //.withNew_group("Test1"));
    }
  }

  @Test(enabled = false)
  public void testContactDeletion() {

    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().goHome();
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before.without(deletedContact)));
  }

  @Test
  public void testContactDeletionDB() {
    app.goTo().goHome();
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().goHome();
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();

    assertThat(after, equalTo(before.without(deletedContact)));
    verifyContactListInUI();
  }

}
