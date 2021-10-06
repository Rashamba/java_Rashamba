package ru.stqa.pft.address.book.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.address.book.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificatoinTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () {
    if (! app.getContactHelper().isTheAContact()) {
      app.getContactHelper().createContact(new ContactData("igor", "Krasnoborodko", "Rashamba", "Voronezh", "666999", null, "test@gmail.com", "27", "September", "1993", "TestAddress", "777"));
    }
  }

  @Test
  public void testContactModificatoin() {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() -1;
    ContactData contact = new ContactData(before.get(before.size() -1).getId(),"Konstantin", "Krasnoborodko", "Rashamba", "Voronezh", "777999", "Egar", "test@gmail.com", "27", "September", "1993", "TestAddress", "777");
    app.getContactHelper().modifyContact(index, contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
