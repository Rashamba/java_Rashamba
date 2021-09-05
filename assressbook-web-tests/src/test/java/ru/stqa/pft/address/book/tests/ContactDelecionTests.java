package ru.stqa.pft.address.book.tests;

import org.testng.annotations.Test;

public class ContactDelecionTests extends TestBase {

  @Test
  public void testContactDelecion() {
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().closeTheNotification();
    app.getContactHelper().returnToContactPage();
  }
}
