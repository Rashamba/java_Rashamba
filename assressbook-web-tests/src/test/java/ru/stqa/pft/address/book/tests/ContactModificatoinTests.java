package ru.stqa.pft.address.book.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.address.book.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificatoinTests extends TestBase {

  @Test
  public void testContactModificatoin() {
    if (! app.getContactHelper().isTheAContact()) {
      app.getContactHelper().createContact(new ContactData("igor", "Krasnoborodko", "Rashamba", "Voronezh", "666999", null, "test@gmail.com", "27", "September", "1993", "TestAddress", "777"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() -1);
    ContactData contact = new ContactData(before.get(before.size() -1).getId(),"igor", "Krasnoborodko", "Rashamba", "Voronezh", "777999", "Egar", "test@gmail.com", "27", "September", "1993", "TestAddress", "777");
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
