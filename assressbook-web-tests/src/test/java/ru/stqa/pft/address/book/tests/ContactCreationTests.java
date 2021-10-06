package ru.stqa.pft.address.book.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.address.book.model.ContactData;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Igor").withLastName("Krasnoborodko")
            .withNickname("Rashamba").withHome("Voronezh").withMobile("666999").withEmail("test@gmail.com").withBday("27")
            .withBmonth("September").withByear("1993").withAddress2("TestAddress").withPhone2("777");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals( after, before);
  }

}