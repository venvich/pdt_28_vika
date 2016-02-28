package ru.stqa.ptd28.sandbox;

public class Util {
  public static void main(String[] args) {

    Point p1 = new Point(1.0, 3.0);
    Point p2 = new Point(5.0, -4.0);

    Point dist = new Point(p1, p2);
    System.out.println("Расстояние между точками: " + dist.distance(p1, p2));
  }
}

