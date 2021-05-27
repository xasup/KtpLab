package com.company;

public class Point3d extends Point2d {
    /* трехмерный класс точки. */

    private double zCoord;  // координата Z

    public Point3d(double x, double y, double z) {
        /* Конструктор инициализации */
        super (x,y);
        this.zCoord=z;
    }

    public Point3d() {
        /* Конструктор по умолчанию */
        // Вызовите конструктор с двумя параметрами и определите источник
        this(0, 0, 0);
    }

    public double getZ() {
        /* Возвращение координаты Z */
        return zCoord;
    }

    public void setZ(double val) {
        /* Установка значения координаты Z */
        zCoord = val;
    }
    public boolean equals(Point3d otherPoint) {
        return this.getX() == otherPoint.getX() &&
               this.getY() == otherPoint.getY() &&
               this.getZ() == otherPoint.getZ();
    }

    public double distanceTo(Point3d otherPoint) {
        return Math.sqrt(
                Math.pow(this.getX() - otherPoint.getX(), 2) +
                Math.pow(this.getY() - otherPoint.getY(), 2) +
                Math.pow(this.getZ() - otherPoint.getZ(), 2));
    }
}
