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
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData("igor", "Krasnoborodko", "Rashamba", "Voronezh", "666999", null, "test@gmail.com", "27", "September", "1993", "TestAddress", "777"));
    }
  }

  @Test
  public void testContactModificatoin() {
    List<ContactData> before = app.contact().list();
    int index = before.size() -1;
    ContactData contact = new ContactData(before.get(index).getId(),"Konstantin", "Krasnoborodko", "Rashamba", "Voronezh", "777999", "Egar", "test@gmail.com", "27", "September", "1993", "TestAddress", "777");
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
