package ru.stqa.pft.address.book.tests;

import org.testng.annotations.Test;

public class GroupDelecionTests extends TestBase{

  @Test
  public void testGroupDelecion() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
  }

}
