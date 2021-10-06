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
      app.contact().create(new ContactData().withFirstName("Igor").withLastName("Krasnoborodko")
              .withNickname("Rashamba").withHome("Voronezh").withMobile("666999").withEmail("test@gmail.com").withBday("27")
              .withBmonth("September").withByear("1993").withAddress2("TestAddress").withPhone2("777"));
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
