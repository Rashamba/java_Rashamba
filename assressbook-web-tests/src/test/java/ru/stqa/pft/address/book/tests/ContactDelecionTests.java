package ru.stqa.pft.address.book.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.address.book.model.ContactData;

import java.util.List;

public class ContactDelecionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () {
    if (! app.getContactHelper().isTheAContact()) {
      app.getContactHelper().createContact(new ContactData("igor", "Krasnoborodko", "Rashamba", "Voronezh", "666999", null, "test@gmail.com", "27", "September", "1993", "TestAddress", "777"));
    }
  }

  @Test
  public void testContactDelecion() {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() -1;
    app.getContactHelper().delete(index);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }

}
