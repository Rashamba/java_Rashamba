package ru.stqa.pft.address.book.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.address.book.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests  extends TestBase{

  @BeforeMethod
  public void ensurePreconditions () {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Igor").withLastName("Krasnoborodko")
              .withPhoneHome("222").withMobile("333").withPhoneWork("444")
              .withEmail("test@gmail.com").withEmail2("test2@gmail.com").withEmail3("test3@gmail.com"));
    }
  }

  @Test
  public void testContactPhones() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHome(), contact.getMobile(), contact.getWork())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}
