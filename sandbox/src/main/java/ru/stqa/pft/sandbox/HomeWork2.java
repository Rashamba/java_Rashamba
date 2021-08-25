package ru.stqa.pft.sandbox;

public class HomeWork2 {


  public static void main(String[] args) {

    Point p1 = new Point(34, 15);
    Point p2 = new Point(55, 6);
    System.out.println("Растояние между точками с координатами " + p1.x + ", " + p1.y + " и " + p2.x + ", " + p2.y + " = " + p1.distance(p2));}

}
