package ru.stqa.pft.address.book.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.address.book.model.ContactData;
import ru.stqa.pft.address.book.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificatoinTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Igor").withLastName("Krasnoborodko")
              .withNickname("Rashamba").withHome("Voronezh").withMobile("666999").withEmail("test@gmail.com").withBday("27")
              .withBmonth("September").withByear("1993").withAddress2("TestAddress").withPhone2("777"));
    }
  }

  @Test
  public void testContactModificatoin() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().
            withId(modifiedContact.getId()).withFirstName("Konstantin").withLastName("Krasnoborodko")
            .withNickname("Rashamba").withHome("Voronezh").withMobile("666999").withEmail("test@gmail.com").withBday("27")
            .withBmonth("September").withByear("1993").withAddress2("TestAddress").withPhone2("777");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }

}
