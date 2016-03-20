package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {
    
    @Test
    public void testContactCreation() {
      Set<ContactData> before = app.contact().all();
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
      Set<ContactData> after = app.contact().all();
      Assert.assertEquals(after.size(), before.size() + 1);

      contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
      before.add(contact);
      //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
      Assert.assertEquals(before, after);
    }
}
