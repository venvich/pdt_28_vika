package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

  @Test
  public void testContactEmails() {
    app.goTo().gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    //assertThat(contact.getEmail(), equalTo(cleaned(contactInfoFromEditForm.getEmail())));
    //assertThat(contact.getEmail2(), equalTo(cleaned(contactInfoFromEditForm.getEmail2())));
    //assertThat(contact.getEmail3(), equalTo(cleaned(contactInfoFromEditForm.getEmail3())));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]]", "");
  }

  private Object mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactEmailTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

}
