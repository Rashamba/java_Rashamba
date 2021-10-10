package ru.stqa.pft.address.book.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.address.book.model.ContactData;

public class ContactPhoneTests  extends TestBase{

  @BeforeMethod
  public void ensurePreconditions () {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Igor").withLastName("Krasnoborodko")
              .withNickname("Rashamba").withHome("222").withMobile("333").withWork("444").withEmail("test@gmail.com").withBday("27")
              .withBmonth("September").withByear("1993").withAddress2("TestAddress").withPhone2("777"));
    }
  }

  @Test
  public void testContactPhones() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  }

}
