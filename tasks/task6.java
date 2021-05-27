package com.company;
import java.lang.reflect.Array;
import java.util.*;
import java.math.BigInteger;

import java.time.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

public class task6 {
    public static void main(String[] args){
        System.out.println("Задание 1 = " + hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println("Задание 2 = " + collect("intercontinentalisationalism", 6));
        System.out.println("Задание 3 = " + nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println("Задание 4 = " + Arrays.toString(twoProduct(new int[] {1, 2, 3, 9, 4, 5, 15, 3}, 45)));
        System.out.println("Задание 5 = " + Arrays.toString(isExact(6)));
        System.out.println("Задание 6 = " + fractions("0.(6)"));
        System.out.println("Задание 7 = " + pilish_string("33314444"));
        System.out.println("Задание 8 = " + generateNonconsecutive(3));
        System.out.println("Задание 9 = " + isValid("aabbccddeefghi"));
        System.out.println("Задание 10 = " + Arrays.deepToString(sumsUp(new int[] {1, 6, 5, 4, 8, 2, 3, 7})));
    }
    /* Метод для задачи 1 из блока 6/6
Создайте функцию, которая принимает две строки. Первая строка содержит предложение,
содержащее буквы второй строки в последовательной последовательности, но в другом порядке.
Скрытая анаграмма должна содержать все буквы, включая дубликаты, из второй строки в любом порядке
и не должна содержать никаких других букв алфавита.
Напишите функцию, чтобы найти анаграмму второй строки, вложенную где-то в первую строку.
Вы должны игнорировать регистр символов, любые пробелы и знаки препинания и возвращать анаграмму
 в виде строчной строки без пробелов или знаков препинания.
Примечание:
- Совершенная анаграмма содержит все буквы оригинала в любом порядке, ни больше, ни меньше.
- Если в предложении нет скрытой анаграммы, верните "not found".
- Как и в приведенных выше примерах, скрытая анаграмма может начинаться или заканчиваться
частично через слово и/или охватывать несколько слов и может содержать знаки препинания и другие не-альфа-символы.
- Игнорируйте регистр символов и любые встроенные не-альфа-символы.
- Если в предложении больше 1 результата, верните ближайший к началу.
     */
    public static int[] getSet(String str) {
        int[] set = new int[26];
        for (char c : str.toCharArray())
            set[c - 97]++;
        return set;
    }
    public static String Let(String str) {
        str = str.toLowerCase();
        String res = "";
        for (char c : str.toCharArray())
            if (97 <= c && c <= 122)
                res += c;
        return res;
    }
    public static String hiddenAnagram(String a, String b) {
        a = Let(a);
        b = Let(b);
        int[] setB = getSet(b);
        for (int i = 0; i <= a.length() - b.length(); i++) {
            String substr = a.substring(i, i+b.length());
            int[] setA = getSet(substr);
            if (Arrays.equals(setA, setB)) {
                String res = "";
                for (char c : substr.toCharArray())
                    if (97 <= c && c <= 122)
                        res += c;
                return res;
            }
        }
        return "not found";
    }
    /* Метод для задачи 2 из блока 6/6
Напишите функцию, которая возвращает массив строк, заполненных из срезов символов
 n-длины данного слова (срез за другим, в то время как n-длина применяется к слову).
Примечания:
- Убедитесь, что результирующий массив лексикографически упорядочен.
- Возвращает пустой массив, если заданная строка меньше n.
- Ожидается, что вы решите эту задачу с помощью рекурсивного подхода.
     */
    public static List<Object> collect(String str, int n) {
        List<Object> lst = new ArrayList();
        if (str.length() < n) {
            return lst;
        } else {
            lst.add(str.substring(0, n));
            lst.addAll(collect(str.substring(n), n));
            List<Object> list = (List)lst.stream().sorted().collect(Collectors.toList());
            return list;
        }
    }
    /* Метод для задачи 3 из блока 6/6
В шифре Nico кодирование осуществляется путем создания цифрового ключа и присвоения
каждой буквенной позиции сообщения с помощью предоставленного ключа.
Создайте функцию, которая принимает два аргумента, message и key, и возвращает закодированное сообщение.
Существуют некоторые вариации правил шифрования. Одна из версий правил шифрования изложена ниже:
message = "mubashirhassan"
key = "crazy"
nicoCipher(message, key) ➞ "bmusarhiahass n"
Шаг 1: Назначьте числа отсортированным буквам из ключа:
"crazy" = 23154
Шаг 2: Назначьте номера буквам данного сообщения:
2 3 1 5 4
---------
m u b a s
h i r h a
s s a n
Шаг 3: Сортировка столбцов по назначенным номерам:
1 2 3 4 5
---------
b m u s a
r h i a h
a s s n
Шаг 4: Верните закодированное сообщение по строкам:
eMessage = "bmusarhiahass n"
     */
    public static int[] getCharset(String word) {
        int[] charset = new int[127];
        for (char c : word.toCharArray()) charset[c]++;
        return charset;
    }
    public static String nicoCipher(String message, String key) {
        for (int i = 0; i < (message.length()+key.length()) % key.length(); i++)
            message += ' ';
        int[] set = getCharset(key);
        int[] setCount = set.clone();
        int counter = 1;
        for (int i = 0; i < set.length; i++)
            if (set[i] != 0) {
                if (set[i] > 1)
                    counter += set[i] - 1;
                set[i] = counter++;
            }
        int[] offsets = new int[key.length()];
        for (int i = 0; i < key.length(); i++)
            offsets[set[key.charAt(i)]-setCount[key.charAt(i)]--] = i;
        String res = "";
        for (int i = 0; i < message.length(); i++) {
            int index = (i / offsets.length) * offsets.length + offsets[i % offsets.length];
            res += message.charAt(index);
        }
        return res;
    }
    /* Метод для задачи 4 из блока 6/6
Создайте метод, который принимает массив arr и число n и возвращает массив
 из двух целых чисел из arr, произведение которых равно числу n следующего вида:
[value_at_lower_index, value_at_higher_index]
Убедитесь, что вы возвращаете массив из двух целых чисел, который точно делит n
(произведение n) и что индексы совпадают с указанным выше форматом. Таким образом,
сортировка значений основана на восходящих индексах.
Примечание:
- Дубликатов не будет.
- Возвращает пустой массив, если совпадение не найдено.
- Всегда считайте, что пара рассматриваемого элемента (текущий элемент,
на который указывали во время поиска) находится слева от него.
- Массив может иметь несколько решений (произведений n), поэтому возвращайте
первое найденное полное совпадение (как описано выше).
     */
    public static int[] twoProduct(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        for (int m : arr) {
            if (n % m == 0 && set.contains(n / m))
                return new int[] {n/m, m};
            set.add(m);
        }
        return new int[] {};
    }
    /* Метод для задачи 5 из блока 6/6
Создайте рекурсивную функцию, которая проверяет, является ли число точной верхней границей
факториала n. Если это так, верните массив точной факториальной границы и n, или иначе, пустой массив.
Примечание:
- Ожидается, что вы решите эту задачу с помощью рекурсии.
     */
    public static int[] isExact(int f, int m, int n) {
        if (f < n)
            return isExact(f*(m+1), m+1, n);
        return new int[] {f, m};
    }
    public static int[] isExact(int n) {
        int[] res = isExact(1, 1, n);
        if (res[0] == n) return res;
        return new int[] {};
    }
    /* Метод для задачи 6 из блока 6/6
Деление на дробь часто приводит к бесконечно повторяющейся десятичной дроби.
1/3=.3333333... 1/7=.142857142857...
Создайте функцию, которая принимает десятичную дробь в строковой форме с повторяющейся
частью в круглых скобках и возвращает эквивалентную дробь в строковой форме и в наименьших членах.
     */
    public static String fractions(String frac) {
        int startBracket = frac.indexOf('(');
        if (startBracket != -1) {
            String f = frac.substring(startBracket+1, frac.length()-1);
            frac = frac.substring(0, startBracket);
            for (int i = 0; i < 9 - f.length(); i++)
                frac += f;
        }
        double a = Double.parseDouble(frac);
        int div = 2;
        while (Math.ceil(a * div) - a * div > 0.000001) div++;
        return "" + (int)Math.ceil(a * div) + "/" + div;
    }
    /* Метод для задачи 7 из блока 6/6
В этой задаче преобразуйте строку в серию слов (или последовательности символов),
разделенных одним пробелом, причем каждое слово имеет одинаковую длину, заданную первыми
15 цифрами десятичного представления числа Пи:
3.14159265358979
Если строка содержит больше символов, чем общее количество, заданное суммой цифр Пи,
неиспользуемые символы отбрасываются, и вы будете использовать только те, которые необходимы для формирования 15 слов.
String = "HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE"
Pi String = "HOW I NEED A DRINK ALCOHOLIC IN NATURE AFTER THE HEAVY LECTURES INVOLVING QUANTUM MECHANICS"
// Every word has the same length of the digit of Pi found at the same index ?
// "HOW" = 3, "I" = 1, "NEED" = 4, "A" = 1, "DRINK" = 5
// "ALCOHOLIC" = 9, "IN" = 2, "NATURE" = 6, "AFTER" = 5
// "THE" = 3, "HEAVY" = 5, "LECTURES" = 8, "INVOLVING" = 9
// "QUANTUM" = 7, "MECHANICS" = 9
// 3.14159265358979
Также, если строка содержит меньше символов, чем общее количество, заданное суммой цифр
Пи, в любом случае вы должны соблюдать последовательность цифр для получения слов.
String = "FORALOOP"
Pi String = "FOR A LOOP"
// Every word has the same length of the digit of Pi found at the same index ?
// "FOR" = 3, "A" = 1, "LOOP" = 4
// 3.14
Если буквы, содержащиеся в строке, не совпадают в точности с цифрами, в этом случае вы
будете повторять последнюю букву, пока слово не будет иметь правильную длину.
String = "CANIMAKEAGUESSNOW"
Pi String = "CAN I MAKE A GUESS NOWWWWWWW"
// Every word has the same length of the digit of Pi found at the same index ?
// "CAN" = 3, "I" = 1, "MAKE" = 4, "A" = 1, "GUESS" = 5, "NOW" = 3
// 3.14153 (Wrong!)
// The length of the sixth word "NOW" (3)...
// ...doesn't match the sixth digit of Pi (9)
// The last letter "W" will be repeated...
// ...until the length of the word will match the digit
// "CAN" = 3, "I" = 1, "MAKE" = 4, "A" = 1, "GUESS" = 5, "NOWWWWWWW" = 9
// 3.14159 (Correct!)
Если данная строка пуста, должна быть возвращена пустая строка.
Учитывая строку txt, реализуйте функцию, которая возвращает ту же строку,
отформатированную в соответствии с приведенными выше инструкциями.
Примечание:
- Эта задача представляет собой упрощенную концепцию, вдохновленную Пилишем,
своеобразным типом ограниченного письма, в котором используются все известные возможные
цифры Пи. Потенциально бесконечный текст может быть написан с использованием знаков
препинания и набора дополнительных правил, которые позволяют избежать длинных последовательностей
маленьких цифр, заменяя их словами больше 9 букв и делая так, чтобы композиция выглядела
более похожей на стихотворение вольным стихом.
- Точка, отделяющая целую часть числа Пи от десятичной, не должна учитываться в функции:
она присутствует в инструкциях и примерах только для удобства чтения.
     */
    public static String pilish_string(String str) {
        // тут должна быть функция для высчитывания PI
        String res = "";
        String pi = String.valueOf(Math.PI).replace(".", "");
        int piIndex = 0;
        while (str.length() > 0) {
            int p = pi.charAt(piIndex) - 48;
            int n = Math.min(p, str.length());
            res += str.substring(0, n);
            str = str.substring(n);
            piIndex++;
            if (str.length() > 0) res += ' ';
            else if (p > n)
                for (int i = 0; i < p - n; i++)
                    res += res.charAt(res.length() - 1);
        }
        return res;
    }
    /* Метод для задачи 8 из блока 6/6
Создайте функцию для генерации всех непоследовательных двоичных строк, где
непоследовательные определяется как строка, в которой нет последовательных строк,
и где n определяет длину каждой двоичной строки.
     */
    public static String generateNonconsecutive(int n) {
        String res = "";
        String format = "%" + n + 's';
        int count = 2 << (n-1);
        nextNumber:
        for (int i = 0; i < count; i++) {
            String num = String.format(format, Integer.toBinaryString(i)).replace(' ', '0');
            for (int j = 0; j < n - 1; j++)
                if (num.charAt(j) == '1' && num.charAt(j+1) == '1')
                    continue nextNumber;
            res += num + ' ';
        }
        return res.substring(0, res.length() - 1);
    }
    /* Метод для задачи 9 из блока 6/6
Шерлок считает строку действительной, если все символы строки встречаются одинаковое
количество раз. Также допустимо, если он может удалить только 1 символ из 1 индекса в строке,
а остальные символы будут встречаться одинаковое количество раз. Для данной строки str определите,
действительна ли она. Если да, верните «ДА», в противном случае верните «НЕТ».
Например, если str = "abc", строка действительна, потому что частота символов у всех одинакова.
Если str = "abcc", строка также действительна, потому что мы можем удалить 1 "c" и оставить
по одному символу каждого символа в строке. Однако, если str = "abccc", строка недействительна,
поскольку удаление одного символа не приводит к одинаковой частоте символов.
     */
    public static String isValid(String str) {
        int[] set = getSet(str);
        int[] medium = new int[str.length()];
        for (int i = 0; i < set.length; i++)
            if (set[i] != 0) medium[set[i]]++;
        int cur = 0;
        int max = 0;
        for (int i = 0; i < medium.length; i++)
            if (medium[i] > cur) {
                cur = medium[i];
                max = i;
            }
        boolean index = false;
        for (int i = 0; i < set.length; i++)
            if (set[i] != 0 && max - set[i] != 0) {
                if (index) return "NO";
                index = true;
            }
        return "YES";
    }
    /* Метод для задачи 10 из блока 6/6
Создайте функцию, которая получает каждую пару чисел из массива, который суммирует
до восьми, и возвращает его как массив пар (отсортированный по возрастанию).
     */
    public static int[][] sumsUp(int[] arr) {
        int[][] res = new int[arr.length / 2 + 1][2];
        int index = 0;

        for(int i = 0; i < arr.length; ++i) {
            for(int j = i+1; j < arr.length; ++j) {
                if (arr[i] + arr[j] == 8) {
                    res[index][0] = Math.min(arr[i], arr[j]);
                    res[index][1] = Math.max(arr[i], arr[j]);
                    ++index;
                }
            }
        }

        return res;
    }
}