package ru.stqa.pft.address.book.model;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String nickname;
  private final String home;
  private final String mobile;
  private final String work;
  private final String email;
  private final String bday;
  private final String bmonth;
  private final String byear;
  private final String address2;
  private final String phone2;
  private String group;

  public ContactData(String firstName, String lastName, String nickname, String home, String mobile, String work, String email, String bday, String bmonth, String byear, String address2, String phone2, String group) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.email = email;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
    this.address2 = address2;
    this.phone2 = phone2;
    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
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

  public String getEmail() {
    return email;
  }

  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }

  public String getAddress2() {
    return address2;
  }

  public String getPhone2() {
    return phone2;
  }

  public String getGroup() { return group; }
}
