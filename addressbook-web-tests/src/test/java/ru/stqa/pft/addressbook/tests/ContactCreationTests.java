package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
    
    @Test(enabled = true)
    public void testContactCreation() {
      Contacts before = app.contact().all();
      File photo = new File("src\\test\\resources\\614_0.jpg");
      ContactData contact = new ContactData()
              .withFirstname("Peter")
              .withLastname("Klee")
              .withAddress("Neverstreet 1, Nevertown 1234")
              .withHome("+1234567890")
              .withEmail("peter.klee@gmail.com")
              .withBday("1")
              .withBmonth("January")
              .withByear("1980")
              .withNew_group("Test1")
              .withPhoto(photo);
      app.contact().createContact(contact);
      assertThat(app.contact().count(), equalTo(before.size() + 1));
      Contacts after = app.contact().all();

      assertThat(after, equalTo(
              before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

  @Test(enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src\\test\\resources\\614_0.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}
