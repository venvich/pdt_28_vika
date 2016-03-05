package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTestsWithAlert extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().goHome();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();

  }

}
