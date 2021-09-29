package ru.stqa.pft.address.book.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.address.book.model.ContactData;

public class ContactModificatoinTests extends TestBase {

  @Test
  public void testContactModificatoin() {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("igor", "Krasnoborodko", "Rashamba", "Voronezh", "666999", "Egar", "test@gmail.com", "27", "September", "1993", "TestAddress", "777"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();
  }
}
