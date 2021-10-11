package ru.stqa.pft.address.book.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.address.book.model.ContactData;
import ru.stqa.pft.address.book.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    File photo = new File("src/test/resources/Cat.jpg");
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new ContactData().withFirstName("Ivan").withLastName("Ivanov").withPhoto(photo)
            .withNickname("Nick1").withAddress("address 1").withMobile("111").withEmail("test1@gmail.com")});
    list.add(new Object[]{new ContactData().withFirstName("Petr").withLastName("Petrov").withPhoto(photo)
            .withNickname("Nick2").withAddress("address 2").withMobile("222").withEmail("test2@gmail.com")});
    list.add(new Object[]{new ContactData().withFirstName("Sergei").withLastName("Sergeev").withPhoto(photo)
            .withNickname("Nick3").withAddress("address 3").withMobile("333").withEmail("test3@gmail.com")});
    return list.iterator();
  }

  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    Contacts before = app.contact().all();
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test (enabled = false)
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