package com.company;

import java.util.Arrays;
import java.util.Locale;

public class task4 {
    public static void main(String[] args){
        System.out.println("Задание 1 = " + sevenBoom(new int[] {8,6,33,100, 97}));
        System.out.println("Задание 2 = " + cons(new int[] {5, 6, 7, 8, 9}));
        System.out.println("Задание 3 = " + unmix("lPaeesh le pemu mnxit ehess rtnisg"));
        System.out.println("Задание 4 = " + noYelling("I just!!! can!!! not!!! believe!!! it!!!"));
        System.out.println("Задание 5 = " + xPronounce("Inside the box was a xylophone"));
        System.out.println("Задание 6 = " + largestGap(new int[] {14,13,7,1,4,12,3,7,7,12,11,5,7}));
        System.out.println("Задание 7 = " + obrCode(7977));
        System.out.print("Задание 8 = "); commonLastVowel("Watch the characters dance!");
        System.out.println("Задание 9 = " + memeSum(1222, 30277));
        System.out.println("Задание 10 = " + unrepeated("teshahset"));
    }
    /* Метод для задачи 1 из блока 4/6
Создайте функцию, которая принимает массив чисел и возвращает "Бум!", если в массиве появляется цифра 7.
В противном случае верните "в массиве нет 7".
     */
    public static String sevenBoom(int[] mas){
        String c=null;
        for (int i=0;i<mas.length;i++){
            String d = String.valueOf(mas[i]);
            if (d.matches("(.*)7(.*)")){
                c="Boom";}
            else c="there is no 7 in the array";
        }
        return c;
    }
    /* Метод для задачи 2 из блока 4/6
Создайте функцию, которая определяет, могут ли элементы в массиве быть переупорядочены, чтобы сформировать
последовательный список чисел, где каждое число появляется ровно один раз.
     */
    public static boolean cons(int[] m){
        Arrays.sort(m);
        //Проверка на единожное появление
        for (int i=0;i<m.length;i++){
            int count = 0;
            int num = m[i];
            for (int k = 0; k < m.length; k++){if (m[k] == num) count++;}
            if (count == 2) return false;
        }
        //Проверка на последовательность
        int posl=0;
        for (int i=1;i<m.length;i++){
            if (m[i]-m[i-1]==1) posl++;
        }
        return posl==m.length-1;
    }
    /* Метод для задачи 3 из блока 4/6
lPaeesh le pemu mnxit ehess rtnisg! О, извините, это должно было быть: Пожалуйста, помогите мне распутать эти строки!
Каким-то образом все строки перепутались, каждая пара символов поменялась местами.
Помоги отменить это, чтобы снова понять строки.
     */
    public static String unmix(String s){
        char b;
        char[] mas=s.toCharArray();
        for (int i=0;i<mas.length;i++){
            if (i%2!=0){
                b=mas[i];
                mas[i]=mas[i-1];
                mas[i-1]=b;
            }
        }
        return s=String.valueOf(mas);
    }
    /* Метод для задачи 4 из блока 4/6
Создать функцию, которая преобразует предложения, заканчивающиеся несколькими вопросительными
знаками ? или восклицательными знаками ! в предложение, заканчивающееся только одним, без
изменения пунктуации в середине предложений.
     */
    public static String noYelling(String s){
        while (s.endsWith("!!")||(s.endsWith("??"))){
            s=s.substring(0,s.length()-1);
            s=noYelling(s);
        }
        return s;
    }
    /* Метод для задачи 5 из блока 4/6
Создайте функцию, которая заменяет все x в строке следующими способами:
Замените все x на "cks", ЕСЛИ ТОЛЬКО:
Слово начинается с "x", поэтому замените его на "z".
Слово-это просто буква "х", поэтому замените ее на "ecks".
     */
    public static String xPronounce(String st){
        st=st.replaceAll("x","cks");
        st=st.replaceAll("\sx","z");
        st=st.replaceAll("\sx\s","ecks");
        return st;
    }
    /* Метод для задачи 6 из блока 4/6
Учитывая массив целых чисел, верните наибольший разрыв между отсортированными элементами массива.
     */
    public static int largestGap(int[] mass){
        Arrays.sort(mass);int maxi=-10000000;
        for (int i=1; i<mass.length;i++){
            if (maxi<(mass[i]-mass[i-1])) maxi=mass[i]-mass[i-1];
        }
        return maxi;
    }
    /* Метод для задачи 7 из блока 4/6
Это вызов обратного кодирования. Обычно вам дают явные указания о том, как создать функцию.
Здесь вы должны сгенерировать свою собственную функцию, чтобы удовлетворить соотношение между входами и выходами.
Ваша задача состоит в том, чтобы создать функцию, которая при подаче входных данных ниже производит показанные
примеры выходных данных.
     */
    public static int obrCode(int a){
        String d=String.valueOf(a);
        char[] s=d.toCharArray();
        Arrays.sort(s);
        int b=Integer.parseInt(String.valueOf(s));
        return a-b;
    }
    /* Метод для задачи 8 из блока 4/6
Создайте функцию, которая принимает предложение в качестве входных данных и возвращает наиболее распространенную
последнюю гласную в предложении в виде одной символьной строки.
     */
    public static void commonLastVowel(String s){
        String Vowel = "eyuioa";
        s=s.replace("."," ");
        s=s.replace(","," ");
        s=s.replace("!"," ");
        s=s.replace("?"," ");
        s=s.replaceAll("  ", " ");
        s=s.toLowerCase();
        String[] word = s.split(" ");
        int[] arr= new int[6];
        int k, kmax=0, max=0;
        for (String w:word){
            k=Vowel.indexOf(w.charAt(w.length()-1));
            if (k!=-1){
                arr[k]+=1;
                if (arr[k]>max){
                    max=arr[k];
                    kmax=k;
                }
            }
        }
        if (max!=0) System.out.println(Vowel.charAt(kmax));
    }
    /* Метод для задачи 9 из блока 4/6
Для этой задачи забудьте, как сложить два числа вместе. Лучшее
объяснение того, что нужно сделать для этой функции, - это этот мем:
     */
    public static int memeSum(int c1, int c2) {
        String sum="";
        int maxLen=Math.max(String.valueOf(c1).length(),String.valueOf(c2).length());
        for (int i=maxLen-1;i>=0;i--){
            sum=Integer.toString(c1%10+c2%10)+sum;
            c1/=10;c2/=10;
        }
        return Integer.parseInt(sum);
    }
    /* Метод для задачи 10 из блока 4/6
Создайте функцию, которая удалит все повторяющиеся символы в слове, переданном этой функции.
Не просто последовательные символы, а символы, повторяющиеся в любом месте строки.
     */
    public static String unrepeated(String s){
        String res="";
        for (int i=0;i<s.length();i++) {
            if (!res.contains(String.valueOf(s.charAt(i))))
                res += s.charAt(i);
        }
        return res;
    }
}