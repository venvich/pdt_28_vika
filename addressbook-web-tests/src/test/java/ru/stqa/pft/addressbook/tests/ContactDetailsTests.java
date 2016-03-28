package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTests extends TestBase {

  @Test
  public void testContactDetails() {
    app.goTo().gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();

    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm4Details(contact);
    app.contact().getDetails();
    //ContactData detailsInfo = app.contact().infoDetails(contact);
    assertThat(contact.getAllNeededDetails(), equalTo(mergeDetails(contactInfoFromEditForm)));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]]", "");
  }

  private Object mergeDetails(ContactData contact) {
    return Arrays.asList
              (contact.getFirstname(), contact.getLastname(), contact.getAddress(),
               contact.getHome(), contact.getMobile(), contact.getWork(),
               contact.getEmail(), contact.getEmail2(), contact.getEmail3(),
               contact.getBday(), contact.getBmonth(), contact.getByear(),
               contact.getAddress2(), contact.getNewGroup())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactDetailsTests::cleaned)
            .collect(Collectors.joining("\n"));
  }
}

