package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTestsWithAlert extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    File photo = new File("src\\test\\resources\\614_0.jpg");
    if (app.db().contacts().size() == 0) {
      app.goTo().goHome();
      app.contact().createContact(new ContactData()
              .withFirstname("Paul")
              .withLastname("Miller")
              .withAddress("Everstreet 1, Evertown 1234")
              .withHome("+3234567890")
              .withEmail("paul.miller@gmail.com")
              .withBday("3")
              .withBmonth("January")
              .withByear("1986")
              .withPhoto(photo));
              //.withNew_group("Test1"));
    }
  }

  @Test(enabled = false)
  public void testContactDeletionWithAlert() {

    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().deleteContactWithAlert(deletedContact);
    app.goTo().goHome();
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before.without(deletedContact)));

  }

  @Test
  public void testContactDeletionWithAlertDB() {
    app.goTo().goHome();
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().deleteContactWithAlert(deletedContact);
    app.goTo().goHome();
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();

    assertThat(after, equalTo(before.without(deletedContact)));
    verifyContactListInUI();

  }
}
