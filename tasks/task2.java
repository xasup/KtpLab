package com.company;

public class Task2 {
    public static int oppositeHouse(int num, int street) {
        return (street * 2 - (num - 1));
    }

    public static String nameShuffle(String name, String surname) {
        return surname + " " + name;
    }

    public static double discount(double cost, double proc) {
        proc = 1 - (proc / 100);
        return cost * proc;
    }

    public static double differenceMaxMin(double[] array) {
        double max = -9999;
        double min = 9999;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        return max - min;
    }

    public static int equal(int a, int b, int c) {
        int k = -1;
        if ((a == b) && (b == c) && (c == a))
            k = 3;
        else if ((a == b) && (b != c) && (c != a))
            k = 2;
        else if ((b == c) && (a != c) && (a != b))
            k = 2;
        else if ((a == c) && (b != c) && (b != a))
            k = 2;
        else if ((a != b) & (b != c) & (c != a))
            k = 0;
        return k;
    }

    public static String reverse(String s) {
        String a = "";
        for (int i = s.length() - 1; i >= 0; --i)
            a += s.charAt(i);
        return a;
    }
    public static int programmers(int zp1, int zp2, int zp3){
        int max = zp1;

        if (zp2>max)
            max=zp2;
        if(zp3>max)
            max=zp3;

        int min=zp1;

        if (zp2<min)
            min=zp2;
        if (zp3<min)
            min=zp3;
        return max-min;
    }
    public static boolean getXO(String str)    {
        int k1 = 0;
        int k2 = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) == 'x') | (str.charAt(i) == 'X'))
                k1++;
            if ((str.charAt(i) == 'o') | (str.charAt(i) == 'O'))
                k2++;
        }
        return k1 == k2;
    }
    public static String bomb(String str){
        int k=0;
        str = str.toLowerCase();
        if (str.contains("bomb"))
            return "DUCK!";
        else return "Relax there's no bomb";
    }
    public static boolean sameAscii(String str1, String str2)
    {
        return str1.chars().sum() == str2.chars().sum();
    }
}

