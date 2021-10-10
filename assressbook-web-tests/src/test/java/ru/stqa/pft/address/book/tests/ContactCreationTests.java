package ru.stqa.pft.address.book.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.address.book.model.ContactData;
import ru.stqa.pft.address.book.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Igor").withLastName("Krasnoborodko")
            .withNickname("Rashamba").withAddress("Test123").withPhoneHome("222").withMobile("333").withPhoneWork("444")
            .withEmail("test1@gmail.com").withEmail2("test2@gmail.com").withEmail3("test3@gmail.com").withBday("27")
            .withBmonth("September").withByear("1993");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadContactCreation() {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Igor'").withLastName("Krasnoborodko")
            .withNickname("Rashamba").withAddress("Test123").withPhoneHome("222").withMobile("333").withPhoneWork("444")
            .withEmail("test1@gmail.com").withEmail2("test2@gmail.com").withEmail3("test3@gmail.com").withBday("27")
            .withBmonth("September").withByear("1993");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

}