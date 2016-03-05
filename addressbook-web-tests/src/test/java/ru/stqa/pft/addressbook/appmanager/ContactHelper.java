package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoHomePage() {
    wd.findElement(By.xpath("//div/div[4]/div/i/a[2]")).click();
  }

  public void submitContactCreation() {
    wd.findElement(By.xpath(".//*[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getFirtsname2());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("address"), contactData.getAddress());
    type(By.name("address"), contactData.getAddress2());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWork());
    type(By.name("company"), contactData.getCompany());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("homepage"), contactData.getHomepage());
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());
    type(By.name("byear"), contactData.getByear());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getNewGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void selectContact() {
    click(By.id("MassCB"));
  }

  public void initContactModification() {
    click(By.cssSelector("img[alt=\"Edit\"]"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void deleteContact() {

    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void submitContactDeletion() {
    click(By.xpath("(//input[@name='update'])[3]"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    gotoHomePage();
  }
}
