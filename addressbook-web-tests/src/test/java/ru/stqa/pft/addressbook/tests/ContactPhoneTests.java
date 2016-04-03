package ru.stqa.pft.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod(enabled = false)
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
              .withByear("1985"));
             // .withNew_group("Test1"));
    }
  }

  @Test
  public void testContactPhones() {
    app.goTo().gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    //assertThat(contact.getHome(), equalTo(cleaned(contactInfoFromEditForm.getHome())));
    //assertThat(contact.getMobile(), equalTo(cleaned(contactInfoFromEditForm.getMobile())));
    //assertThat(contact.getWork(), equalTo(cleaned(contactInfoFromEditForm.getWork())));
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private Object mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHome(), contact.getMobile(), contact.getWork())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }


  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]]", "");
  }

}
