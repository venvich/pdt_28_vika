package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {
    
    @Test
    public void testContactCreation() {
      List<ContactData> before = app.getContactHelper().getContactList();
      ContactData contact = new ContactData("Peter", "Paul", "Klee", "First.Last", "Dr.", "Test GmbH",
                "Neverstreet 1, Nevertown 1234", "Neverstreet 1, Nevertown 1234",
                "+1234567890", "", "", "",
                "", "", "", "www.mypage.com", "1", "January", "1980", "Test1");
      app.getContactHelper().createContact(contact);
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size() + 1);

      before.add(contact);
      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
