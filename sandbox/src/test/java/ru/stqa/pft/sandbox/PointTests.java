package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptd28.sandbox.Point;

public class PointTests {

  @Test
  /**
   * Дистанция между точками с координатами (0,2) и (1,5) = 3.1622776601683795
   */
  public void testDistance1() {

    Point p1 = new Point(0.0, 2.0);
    Point p2 = new Point(1.0, 5.0);
    Point dist = new Point(p1, p2);

    Assert.assertEquals(dist.distance(p1, p2), 3.1622776601683795);
  }

  @Test
  /**
   * Дистанция между точками с координатами (1,3) и (5,-4) = 8.06225774829855
   */
  public void testDistance2() {

    Point p1 = new Point(1.0, 3.0);
    Point p2 = new Point(5.0, -4.0);
    Point dist = new Point(p1, p2);

    Assert.assertEquals(dist.distance(p1, p2), 8.06225774829855);

  }

}
