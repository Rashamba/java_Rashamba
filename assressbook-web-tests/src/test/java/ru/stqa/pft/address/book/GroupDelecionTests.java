package ru.stqa.pft.address.book;

import org.testng.annotations.Test;

public class GroupDelecionTests extends TestBase{

  @Test
  public void testGroupDelecion() {
    gotoGroupPage();
    selectGroup();
    deleteSelectedGroup();
    returnToGroupPage();
  }

}
