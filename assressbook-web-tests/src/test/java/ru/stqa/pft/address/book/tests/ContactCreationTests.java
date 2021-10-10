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
            .withNickname("Rashamba").withHome("222").withMobile("333").withWork("444").withEmail("test@gmail.com").withBday("27")
            .withBmonth("September").withByear("1993").withAddress2("TestAddress").withPhone2("777");
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
            .withNickname("Rashamba").withHome("222").withMobile("333").withWork("444").withEmail("test@gmail.com").withBday("27")
            .withBmonth("September").withByear("1993").withAddress2("TestAddress").withPhone2("777");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

}