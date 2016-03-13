package ru.stqa.pft.addressbook.model;

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
  private final String new_group;
  private int id;



  public ContactData(int id, String firstname, String firtsname2, String lastname,
                     String nickname, String title, String company, String address,
                     String address2, String home, String mobile, String work,
                     String fax, String email, String email2, String email3, String homepage,
                     String bday, String bmonth, String byear, String new_group) {
    this.id = id;
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
    this.new_group = new_group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (home != null ? !home.equals(that.home) : that.home != null) return false;
    return email != null ? email.equals(that.email) : that.email == null;

  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (home != null ? home.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }

  public ContactData(String firstname, String firtsname2, String lastname,
                     String nickname, String title, String company, String address,
                     String address2, String home, String mobile, String work,
                     String fax, String email, String email2, String email3, String homepage,
                     String bday, String bmonth, String byear, String new_group) {
    this.id = Integer.MAX_VALUE;
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
    this.new_group = new_group;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() { return id; }

  public String getFirstname() { return firstname; }

  public String getFirtsname2() {
    return firtsname2;
  }

  public String getLastname() {
    return lastname;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", address='" + address + '\'' +
            ", home='" + home + '\'' +
            ", email='" + email + '\'' +
            ", id='" + id + '\'' +
            '}';
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

}
