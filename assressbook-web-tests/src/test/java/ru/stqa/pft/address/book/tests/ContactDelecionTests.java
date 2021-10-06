package ru.stqa.pft.address.book.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.address.book.model.ContactData;

import java.util.List;

public class ContactDelecionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () {
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData("igor", "Krasnoborodko", "Rashamba", "Voronezh", "666999", null, "test@gmail.com", "27", "September", "1993", "TestAddress", "777"));
    }
  }

  @Test
  public void testContactDelecion() {
    List<ContactData> before = app.contact().list();
    int index = before.size() -1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }

}
