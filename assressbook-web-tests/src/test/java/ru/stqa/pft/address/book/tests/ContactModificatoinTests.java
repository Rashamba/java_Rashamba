package ru.stqa.pft.address.book.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.address.book.model.ContactData;

public class ContactModificatoinTests extends TestBase {

  @Test
  public void testContactModificatoin() {
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isTheAContact()) {
      app.getContactHelper().createContact(new ContactData("igor", "Krasnoborodko", "Rashamba", "Voronezh", "666999", null, "test@gmail.com", "27", "September", "1993", "TestAddress", "777"));
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("igor", "Krasnoborodko", "Rashamba", "Voronezh", "777999", "Egar", "test@gmail.com", "27", "September", "1993", "TestAddress", "777"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }
}
