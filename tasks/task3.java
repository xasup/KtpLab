package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.OptionalDouble;

import static java.lang.Math.*;

public class task3 {
    public static void main(String[] args){
        System.out.println("Задание 1 = " );millionsRounding(new String[][] {{"Manila", "13923452"},{"Kuala Lumpur", "7996830"}, {"Jakarta", "10770487"}});
        System.out.println("Задание 2 = " + Arrays.toString(otherSides(12)));
        System.out.println("Задание 3 = " + rps("paper","rock"));
        System.out.println("Задание 4 = " + warOfNumber(new int[] {5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243}));
        System.out.println("Задание 5 = " + reverseCase("Happy Birthday"));
        System.out.println("Задание 6 = " + inat("Shrink"));
        System.out.println("Задание 7 = " + doesBrickFit(1,1,1,1,1));
        System.out.println("Задание 8 = " + totalDistance(36.1, 8.6, 3, true));
        System.out.println("Задание 9 = " + mean(new int[] {1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3}));
        System.out.println("Задание 10 = " + parityAnalysis(3));
    }
    /* Метод для задачи 1 из блока 3/6
    Учитывая массив городов и населения, верните массив, в котором все население округлено до
    ближайшего миллиона.
     */
    public static void millionsRounding(String[][] str){
        for (int i=0; i<str.length;i++){
            BigDecimal a = new BigDecimal(str[i][1]);
            a=a.divide(new BigDecimal("1000000")).setScale(0, RoundingMode.HALF_UP);
            str[i][1]=a.toString();
        }
        System.out.println(Arrays.deepToString(str));
    }
    /* Метод для задачи 2 из блока 3/6
    Учитывая самую короткую сторону треугольника 30° на 60° на 90°, вы должны найти другие 2 стороны
    (верните самую длинную сторону, сторону средней длины).
     */
    public static double[] otherSides(int a) {
        //Подсчет сторон
        int b = 2 * a;
        double cr;
        double c = a * sqrt(3);
        //Поиск максимального и среднего
        double maxi = max(c, max(a, b));
        double mini = min(c, min(a, b));
        if ((a == maxi && b == mini) || (b == maxi && a == mini)) {
            cr = c;
        } else {
            if ((a == maxi && c == mini) || (c == maxi && a == mini)) {
                cr = b;
            } else {
                cr = a;
            }
        }
        //Округление
        double scale=Math.pow(10,2);cr=Math.ceil(cr*scale)/scale;
        return new double[]{maxi,cr};
    }
    /* Метод для задачи 3 из блока 3/6
    Создайте функцию, имитирующую игру "камень, ножницы, бумага". Функция принимает входные данные
    обоих игроков (камень, ножницы или бумага), первый параметр от первого игрока, второй от второго
    игрока. Функция возвращает результат как таковой:
    "Игрок 1 выигрывает"
    "Игрок 2 выигрывает"
    "НИЧЬЯ" (если оба входа одинаковы)
     */
    public static String rps(String p1, String p2){
        if ((p1=="rock"&&p2=="scissors")||(p1=="scissors"&&p2=="paper")||(p1=="paper"&&p2=="rock")){
            return "Player 1 wins";
        } else {
            if (p1==p2){
                return "TIE";
            } else{
                return "Player 2 wins";
            }
        }
    }
    /* Метод для задачи 4 из блока 3/6
    Идет великая война между четными и нечетными числами. Многие уже погибли в этой войне, и ваша
    задача-положить этому конец. Вы должны определить, какая группа суммируется больше: четная или
    нечетная. Выигрывает большая группа.
    Создайте функцию, которая берет массив целых чисел, суммирует
    четные и нечетные числа отдельно, а затем возвращает разницу между суммой четных и нечетных чисел.
     */
    public static int warOfNumber(int[] mass){
        int chetSum=0;int nSum=0;int war;
        for (int i=0;i<mass.length;i++){
            if (mass[i]%2==0){chetSum=chetSum+mass[i];
            } else {nSum=nSum+mass[i];
            }
        }
        return abs(nSum-chetSum);
    }
    /* Метод для задачи 5 из блока 3/6
Учитывая строку, создайте функцию для обратного обращения. Все буквы в нижнем регистре должны быть
прописными, и наоборот.
     */
    public static String reverseCase(String a){
        a = a.codePoints()
                .map(i -> Character.isUpperCase(i)
                        ? Character.toLowerCase(i)
                        : Character.toUpperCase(i))
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
        return a;
    }
    /* Метод для задачи 6 из блока 3/6
Создайте функцию, которая принимает строку из одного слова и выполняет следующие действия:
Конкатенирует inator до конца, если слово заканчивается согласным, в противном случае вместо него
конкатенирует -inator
Добавляет длину слова исходного слова в конец, снабженный '000'
     */
    public static String inat(String st){
        int k=0;String s = null;
        char[] strToArray = st.toCharArray(); // Преобразуем строку st в массив символов (char)
        k=strToArray.length*1000; char[] vowels={'a','e','i','o','u','y'};
        for(int c=0;c<vowels.length;c++){
            if (vowels[c] == strToArray[strToArray.length-1]) {
                s= st+"- inator"+" "+k;
            } else {
                s= st+"inator"+" "+k;
            }
        }
        return s;
    }
    /* Метод для задачи 7 из блока 3/6
Напишите функцию, которая принимает три измерения кирпича: высоту(a), ширину(b) и глубину(c) и
возвращает true, если этот кирпич может поместиться в отверстие с шириной(w) и высотой(h).
     */
    public static boolean doesBrickFit(int a, int b, int c, int w, int h){
        return (((w>=a||w>=b)&&h>=c)||((w>=a||w>=c)&&h>=b)||((w>=b||w>=c)&&h>=a));}
    /* Метод для задачи 8 из блока 3/6
Напишите функцию, которая принимает топливо (литры), расход топлива (литры/100 км), пассажиров,
кондиционер (логическое значение) и возвращает максимальное расстояние, которое может проехать автомобиль.
топливо-это количество литров топлива в топливном баке.
Расход топлива-это базовый расход топлива на 100 км (только с водителем внутри).
Каждый дополнительный пассажир увеличивает базовый расход топлива на 5%.
Если кондиционер включен, то его общий (не базовый) расход топлива увеличивается на 10%.
     */
    public static double totalDistance(double top, double ras,int pass,boolean cond){
        ras=pass*ras*5/100+ras;
        if (cond==true) {ras=ras*110/100;}
        return top/ras*100;
    }
    /* Метод для задачи 9 из блока 3/6
Создайте функцию, которая принимает массив чисел и возвращает среднее значение (average) всех этих чисел.
     */
    public static double mean(int[] mass){OptionalDouble res= Arrays.stream(mass).average(); return res.getAsDouble();}
    /* Метод для задачи 10 из блока 3/6
Создайте функцию, которая принимает число в качестве входных данных и возвращает true, если сумма его цифр
 имеет ту же четность, что и все число. В противном случае верните false.
     */
    public static boolean parityAnalysis(int a){
        int sum=0;int b=a;
        while (a>0){
            sum=sum+a%10;
            a=a/10;
        }
        return b%2==sum%2;
    }
}