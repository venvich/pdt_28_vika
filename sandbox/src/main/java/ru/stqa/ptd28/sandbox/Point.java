package ru.stqa.ptd28.sandbox;

public class Point {

  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public Point(Point p1, Point p2) {
    distance(p1, p2);
  }

  public static double distance(Point p1, Point p2){
    return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
  }
}
