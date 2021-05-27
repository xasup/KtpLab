package com.company;

public class Task1 {
    public static int convert (int minutes) {
        return (minutes*60);
    }
    public static int points (int a, int b) {
        return (a*2+b*3);
    }
    public static int footballPoints (int a, int b, int c)
    {
        return (a*3+b);
    }
    public static boolean divisibleByFive (int a) {
        return a % 5 == 0;
    }
    public static boolean and (boolean a, boolean b) {
        if (!a) return false;
        else return b;
    }
    public static int howManyWalls (int n, int w, int h) {
        return (n/(w*h));
    }
    public static int squared(int a) {
            return a * a;
        }
    public static boolean profitableGamble (double prob, int prize, int pay) {
        return prob * prize > pay;
    }
    public static int frames (int fps, int min) {
        return 60*(fps*min);
    }
    public static int mod (int a, int b) {
        return (a-(b*(a/b)));
    }
}