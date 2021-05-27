package com.company;
import java.util.Scanner;

class Lab2 {
    public static Point3d Input3dPoint() {
        /* Считывает точку из ввода пользователя */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координаты точки: ");
        return new Point3d(
                scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
    }

    public static void main(String[] args) {
        Point3d p1, p2, p3;
        p1 = Input3dPoint();
        p2 = Input3dPoint();
        p3 = Input3dPoint();

        if (p1.equals(p2) || p2.equals(p3) || p1.equals(p3)) {
            System.out.println("Одна из точек равна другой");
            return;
        }
        System.out.println("Площадь треугольника = " + computeArea(p1, p2, p3));
    }

    public static double computeArea(Point3d p1, Point3d p2, Point3d p3) {
        /* Вычисляет площадь треугольника, образованного 3 точками */
        double a, b, c, p;
        a = p1.distanceTo(p2);
        b = p1.distanceTo(p3);
        c = p2.distanceTo(p3);
        p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
