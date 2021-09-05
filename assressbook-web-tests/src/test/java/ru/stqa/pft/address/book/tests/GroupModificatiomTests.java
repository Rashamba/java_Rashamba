package ru.stqa.pft.address.book.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.address.book.model.GroupData;

public class GroupModificatiomTests extends TestBase {
  @Test
  public void testGroupModificatoin() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModifacation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}