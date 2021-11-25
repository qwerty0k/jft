package ru.stqa.jft.sandbox;

public class Main {

    public static void main(String[] args) {

        hello("Java!");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(5,6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

        Point p1 = new Point(5, 5);
        Point p2 = new Point(6,6);
        System.out.println("Расстояние между двумя точками с координатами: " + p1.a + "," + p1.b + " и " + p2.a + "," + p2.b + " = " + p1.distance(p1,p2));

    }

    public static void hello(String somebody) {
        System.out.println("Hi " + somebody);
    }

}