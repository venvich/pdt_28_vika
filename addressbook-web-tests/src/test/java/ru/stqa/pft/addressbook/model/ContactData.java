package ru.stqa.pft.addressbook.model;

import java.io.File;
import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
  @Expose
  @Column(name = "firstname")
  private String firstname;
  @XStreamOmitField
  @Column(name = "middlename")
  private String firtsname2;
  @Expose
  @Column(name = "lastname")
  private String lastname;
  @XStreamOmitField
  @Column(name = "nickname")
  private String nickname;
  @XStreamOmitField
  @Column(name = "title")
  private String title;
  @XStreamOmitField
  @Column(name = "company")
  private String company;
  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;
  @XStreamOmitField
  @Column(name = "address2")
  @Type(type = "text")
  private String address2;
  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String home;
  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobile;
  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String work;
  @XStreamOmitField
  @Column(name = "fax")
  @Type(type = "text")
  private String fax;
  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String email;
  @Expose
  @Column(name = "email2")
  @Type(type = "text")
  private String email2;
  @Expose
  @Column(name = "email3")
  @Type(type = "text")
  private String email3;
  @XStreamOmitField
  @Column(name = "homepage")
  @Type(type = "text")
  private String homepage;
  @Expose
  //@Column(name = "bday")
  @Transient
  private String bday;
  @Expose
  //@Column(name = "bmonth")
  @Transient
  private String bmonth;
  @Expose
  //@Column(name = "byear")
  @Transient
  private String byear;
  @XStreamOmitField
  @Transient
  private String new_group;
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;
  @XStreamOmitField
  @Transient
  private String allPhones;
  @XStreamOmitField
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;
  @XStreamOmitField
  @Transient
  private String allEmails;


  // setters
  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withFirtsname2(String firtsname2) {
    this.firtsname2 = firtsname2;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactData withHome(String home) {
    this.home = home;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withWork(String work) {
    this.work = work;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public ContactData withBday(String bday) {
    this.bday = bday;
    return this;
  }

  public ContactData withBmonth(String bmonth) {
    this.bmonth = bmonth;
    return this;
  }

  public ContactData withByear(String byear) {
    this.byear = byear;
    return this;
  }

  public ContactData withNew_group(String new_group) {
    this.new_group = new_group;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }


  // getters
  public int getId() { return id; }

  public File getPhoto() {
    return new File(photo);
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getFirstname() { return firstname; }

  public String getFirtsname2() {
    return firtsname2;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getAddress2() {
    return address2;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getBday() { return bday; }

  public String getBmonth() { return bmonth; }

  public String getByear() { return byear; }

  public String getNewGroup() { return new_group; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + id;
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", id=" + id +
            '}';
  }

}
