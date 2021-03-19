package com.company;

public class Main {
    // Перебирает числа от 2 до 100, выводит простые
    public static void main(String[] args) {
        int i;
        for(i=2; i <= 100; i++)
            if(isPrime(i))
                System.out.println(i);
    }


// Функция определяет является ли аргумент простым числом или нет
    public static boolean isPrime(int n)
    {
        int j;
        for (j = 2; j < n; j++)
        {
        if ((n % j) == 0)
            return false;
        }
            return true;

    }
}
