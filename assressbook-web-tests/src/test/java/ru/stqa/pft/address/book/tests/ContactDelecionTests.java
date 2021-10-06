package ru.stqa.pft.address.book.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.address.book.model.ContactData;
import java.util.Set;

public class ContactDelecionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Igor").withLastName("Krasnoborodko")
              .withNickname("Rashamba").withHome("Voronezh").withMobile("666999").withEmail("test@gmail.com").withBday("27")
              .withBmonth("September").withByear("1993").withAddress2("TestAddress").withPhone2("777"));
    }
  }

  @Test
  public void testContactDelecion() {
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }

}
