package ru.stqa.pft.address.book.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.address.book.model.ContactData;

import java.util.List;

public class ContactDelecionTests extends TestBase {

  @Test (enabled = false)
  public void testContactDelecion() {
    List<ContactData> before = app.getContactHelper().getContactList();
    if (! app.getContactHelper().isTheAContact()) {
      app.getContactHelper().createContact(new ContactData("igor", "Krasnoborodko", "Rashamba", "Voronezh", "666999", null, "test@gmail.com", "27", "September", "1993", "TestAddress", "777"));
    }
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeTheNotification();
    app.getContactHelper().returnToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
