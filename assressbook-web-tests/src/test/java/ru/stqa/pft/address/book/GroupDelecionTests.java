package ru.stqa.pft.address.book;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;

public class GroupDelecionTests extends TestBase{

  @Test
  public void testGroupDelecion() {
    gotoGroupPage();
    wd.findElement(By.name("selected[]")).click();
    wd.findElement(By.xpath("//div[@id='content']/form/input[5]")).click();
    wd.findElement(By.linkText("groups")).click();
  }

}
