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
              .withAddress("Test123").withPhoneHome("222").withMobile("333").withPhoneWork("444")
              .withEmail("test@gmail.com").withEmail2("test2@gmail.com").withEmail3("test3@gmail.com"));
    }
  }

  @Test
  public void testContactModificatoin() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().
            withId(modifiedContact.getId()).withFirstName("Konstantin").withLastName("Krasnoborodko")
            .withAddress("Test123").withPhoneHome("222").withMobile("333").withPhoneWork("444")
            .withEmail("test@gmail.com").withEmail2("test2@gmail.com").withEmail3("test3@gmail.com");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }

}
