package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoHomePage() {
    click(By.linkText("home page"));
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  }

  public void submitContactCreation() {
    wd.findElement(By.xpath(".//*[@id='content']/form/input[21]")).click();
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
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
    attach(By.name("photo"), contactData.getPhoto());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getNewGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  }

  public void initContactModification(int index) {
    //click(By.cssSelector("img[alt=\"Edit\"]"));
    click(By.xpath(".//*[@id='maintable']/tbody/tr[" + index + "]/td[8]/a/img"));
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  }

  public void submitContactModification() {
    click(By.name("update"));
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  }

  public void deleteContact() {

    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  }

  public void submitContactDeletion() {
    click(By.xpath("(//input[@name='update'])[3]"));
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    contactCache = null;
    gotoHomePage();
  }

  public void modify(Set<ContactData> before, ContactData contact) {
    selectContactById(contact.getId());
    initContactModification(before.size() + 1);
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    gotoHomePage();
  }

  public List<ContactData> list() {

    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> rows = wd.findElements(By.xpath("//tbody/tr[@name='entry']"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String email = cells.get(4).getText();
      String phones = cells.get(5).getText();
      ContactData contact = new ContactData()
              .withId(id)
              .withFirstname(firstname)
              .withLastname(lastname)
              .withAddress(address)
              .withHome(phones)
              .withEmail(email);
      contacts.add(contact);
    }
    return contacts;
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.xpath("//tbody/tr[@name='entry']"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String email = cells.get(4).getText();
      String phones = cells.get(5).getText();
      String allNeededDetails = firstname+lastname+address+phones+email;
      //String[] allPhones = phones.split("\n");
      //String[] allEmails = email.split("\n");
      ContactData contact = new ContactData()
              .withId(id)
              .withFirstname(firstname)
              .withLastname(lastname)
              .withAddress(address)
              .withAllPhones(phones)
              .withAllEmails(email)
              .withAllNeededDetails(allNeededDetails);
              //.withHome(allPhones[0])
             // .withMobile(allPhones[1])
             // .withWork(allPhones[2])
              //.withEmail(allEmails[0])
             // .withEmail2(allEmails[1])
              //.withEmail3(allEmails[2]);
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    initContactModificationById(contact.getId());
    submitContactDeletion();
    contactCache = null;
  }

  private void initContactModificationById(int id) {
    click(By.cssSelector("a[href='edit.php?id=" + id + "']"));
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  }

  public void deleteContactWithAlert(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
    contactCache = null;
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId())
            .withFirstname(firstname)
            .withLastname(lastname)
            .withHome(home)
            .withMobile(mobile)
            .withWork(work)
            .withEmail(email)
            .withEmail2(email2)
            .withEmail3(email3);
  }
  public ContactData infoFromEditForm4Details(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.xpath(".//*[@id='content']/form[1]/textarea[1]")).getText();
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId())
            .withFirstname(firstname)
            .withLastname(lastname)
            .withHome(home)
            .withMobile(mobile)
            .withWork(work)
            .withAddress(address)
            .withEmail(email)
            .withEmail2(email2)
            .withEmail3(email3);
  }

  public ContactData infoDetails(ContactData contact) {
    detailsContactById(contact.getId());

    return null;
  }

  private void detailsContactById(int id) {
    click(By.cssSelector("a[href='view.php?id=" + id + "']"));
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    //String details = contactCache.
  }

  public String getDetails() {
    String text = wd.findElement(By.xpath(".//*[@id='content']")).getText();
    System.out.println(text);
    return text;
  }
}
