package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
    
    @Test
    public void testContactCreation() {
      Contacts before = app.contact().all();
      ContactData contact = new ContactData()
              .withFirstname("Peter")
              .withLastname("Klee")
              .withAddress("Neverstreet 1, Nevertown 1234")
              .withHome("+1234567890")
              .withEmail("peter.klee@gmail.com")
              .withBday("1")
              .withBmonth("January")
              .withByear("1980")
              .withNew_group("Test1");
      app.contact().createContact(contact);
      Contacts after = app.contact().all();
      assertThat(after.size(), equalTo(before.size() + 1));

      assertThat(after, equalTo(
              before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}
