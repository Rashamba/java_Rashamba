package ru.stqa.pft.address.book;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    gotoContactCreation();
    fillContactForm(new ContactData("igor", "Krasnoborodko", "Rashamba", "Voronezh", "666999", "Egar", "test@gmail.com", "27", "September", "1993", "TestAddress", "777"));
    submitContactCreation();
    returnToContactPage();
  }

}
