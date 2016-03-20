package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().goHome();
    if (app.contact().all().size() == 0) {
      app.contact().createContact(new ContactData()
              .withFirstname("Markus")
              .withLastname("Meier")
              .withAddress("Everstreet 1, Evertown 1234")
              .withHome("+2234567890")
              .withMobile("+55555")
              .withEmail("markus.meier@gmail.com")
              .withBday("2")
              .withBmonth("January")
              .withByear("1985")
              .withNew_group("Test1"));
    }
  }

  @Test
  public void testContactPhones() {
    app.goTo().gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  }

}
