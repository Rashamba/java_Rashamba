package ru.stqa.pft.address.book.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.address.book.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().createContact(new ContactData("igor", "Krasnoborodko", "Rashamba", "Voronezh", "666999", null, "test@gmail.com", "27", "September", "1993", "TestAddress", "777"));
  }

}