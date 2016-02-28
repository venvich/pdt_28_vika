package ru.stqa.pft.addressbook;

public class ContactData {
  private final String firstname;
  private final String firtsname2;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String address2;
  private final String home;
  private final String mobile;
  private final String work;
  private final String fax;
  private final String email;
  private final String email2;
  private final String email3;
  private final String homepage;
  private final String bday;
  private final String bmonth;
  private final String byear;

  public ContactData(String firstname, String firtsname2, String lastname, String nickname, String title, String company, String address, String address2, String home, String mobile, String work, String fax, String email, String email2, String email3, String homepage, String bday, String bmonth, String byear) {
    this.firstname = firstname;
    this.firtsname2 = firtsname2;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.address2 = address2;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.email = email;
    this.email2 = email2;
    this.email3 = email3;
    this.homepage = homepage;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
  }

  public String getFirstname() {
    return firstname;
  }

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
}
