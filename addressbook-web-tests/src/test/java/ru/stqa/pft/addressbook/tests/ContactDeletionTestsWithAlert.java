package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTestsWithAlert extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().goHome();
    if (app.contact().list().size() == 0) {
      app.contact().createContact(new ContactData()
              .withFirstname("Paul")
              .withLastname("Miller")
              .withAddress("Everstreet 1, Evertown 1234")
              .withHome("+3234567890")
              .withEmail("paul.miller@gmail.com")
              .withBday("3")
              .withBmonth("January")
              .withByear("1986")
              .withNew_group("Test1"));
    }
  }

  @Test
  public void testContactDeletionWithAlert() {

    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().selectContact(index);
    app.contact().deleteContact();
    app.goTo().goHome();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }

}
