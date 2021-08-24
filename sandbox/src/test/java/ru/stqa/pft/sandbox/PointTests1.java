package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests1 {

  @Test
  public void testDistance() {
    Point p = new Point(24, 124, 14, 21);
    Assert.assertEquals(p.distance(),103.4842983258813);
  }
}
