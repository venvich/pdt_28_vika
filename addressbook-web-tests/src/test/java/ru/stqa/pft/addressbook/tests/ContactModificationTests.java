package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;


import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    File photo = new File("src\\test\\resources\\614_0.jpg");
    if (app.db().contacts().size() == 0) {
      app.goTo().goHome();
      app.contact().createContact(new ContactData()
              .withFirstname("Pascal")
              .withLastname("Berger")
              .withAddress("Everstreet 1, Evertown 1234")
              .withHome("+2234567890")
              .withEmail("pascal.berger@gmail.com")
              .withBday("5")
              .withBmonth("February")
              .withByear("1979")
              .withPhoto(photo));
              //.withNew_group("Test1"));
    }
  }

  @Test(enabled = false)
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    File photo = new File("src\\test\\resources\\614_0.jpg");
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
            //.withNew_group("Test1")
            .withPhoto(photo);
    app.contact().modify(contact);
    app.goTo().goHome();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }

  @Test
  public void testContactModificationDB() {
    Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    File photo = new File("src\\test\\resources\\614_0.jpg");
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
            .inGroup(groups.iterator().next())
            //.withNew_group("Test1")
            .withPhoto(photo);
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    app.goTo().goHome();
    Contacts after = app.db().contacts();

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }

}
