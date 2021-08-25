package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests1 {

  @Test
  public void testDistance() {
    Point p1 = new Point(34, 15);
    Point p2 = new Point(55, 6);
    Assert.assertEquals(p1.distance(p2),22.847319317591726);
  }
}
