package ru.stqa.pft.address.book.appmanager;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.address.book.model.ContactData;
import ru.stqa.pft.address.book.model.Contacts;
import java.util.List;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super (wd);
  }

  public void gotoContactCreation() {
    click(By.linkText("add new"));
  }

  public void returnToContactPage() {
    click(By.linkText("home"));
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(@NotNull ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWork());
    type(By.name("email"), contactData.getEmail());
    type(By.name("address2"), contactData.getAddress2());
    type(By.name("phone2"), contactData.getPhone2());
    wd.findElement(By.name("bday")).click();
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
    wd.findElement(By.name("bmonth")).click();
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());
    type(By.name("byear"), contactData.getByear());

  }

  private void initContactModifyByID(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeTheNotification() {
    wd.switchTo().alert().accept();
  }

  public void create(ContactData contact) {
    gotoContactCreation();
    fillContactForm(contact);
    submitContactCreation();
    returnToContactPage();
  }

  public void modify(ContactData contact) {
    initContactModifyByID(contact.getId());
    fillContactForm(contact);
    submitContactModification();
    returnToContactPage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    closeTheNotification();
    returnToContactPage();
  }

  public boolean isTheAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstName = cells.get(2).getText();
      String lastName = cells.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
    }
    return contacts;
  }

}
