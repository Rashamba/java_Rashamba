package ru.stqa.pft.address.book.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.address.book.model.ContactData;

public class ContactDelecionTests extends TestBase {

  @Test
  public void testContactDelecion() {
    if (! app.getContactHelper().isTheAContact()) {
      app.getContactHelper().createContact(new ContactData("igor", "Krasnoborodko", "Rashamba", "Voronezh", "666999", null, "test@gmail.com", "27", "September", "1993", "TestAddress", "777"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeTheNotification();
    app.getContactHelper().returnToContactPage();
  }
}
