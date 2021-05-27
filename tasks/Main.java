package com.company;

public class Main {
    public static void  main(String[] args) {
     System.out.println("Task1");
     System.out.println(Task1.convert(5));
     System.out.println(Task1.convert(3));
     System.out.println(Task1.convert(2));

     System.out.println("Task2");
     System.out.println(Task1.points(13, 12));
     System.out.println(Task1.points(17, 12));
     System.out.println(Task1.points(38, 8));

     System.out.println("Task3");
     System.out.println(Task1.footballPoints(3, 4, 2));
     System.out.println(Task1.footballPoints(5, 0, 2));
     System.out.println(Task1.footballPoints(0, 0, 1));

     System.out.println("Task4");
     System.out.println(Task1.divisibleByFive(5));
     System.out.println(Task1.divisibleByFive(-55));
     System.out.println(Task1.divisibleByFive(37));

     System.out.println("Task5");
     System.out.println(Task1.and(true,false ));
     System.out.println(Task1.and(true,true));
     System.out.println(Task1.and(false, true));
     System.out.println(Task1.and(false, false));

     System.out.println("Task6");
     System.out.println(Task1.howManyWalls(54, 1, 43));
     System.out.println(Task1.howManyWalls(46, 5, 4));
     System.out.println(Task1.howManyWalls(100, 4, 5));
     System.out.println(Task1.howManyWalls(10, 15, 12));
     System.out.println(Task1.howManyWalls(41, 3, 6));

     System.out.println("Task7");
     System.out.println(Task1.squared(5));
     System.out.println(Task1.squared(9));
     System.out.println(Task1.squared(100));

     System.out.println("Task8");
     System.out.println(Task1.profitableGamble(0.2, 50, 9));
     System.out.println(Task1.profitableGamble(0.9, 1, 2));
     System.out.println(Task1.profitableGamble(0.9, 3, 2));

     System.out.println("Task9");
     System.out.println(Task1.frames(1,1));
     System.out.println(Task1.frames(10,1));
     System.out.println(Task1.frames(10,25));

     System.out.println("Task10");
     System.out.println(Task1.mod(5,2));
     System.out.println(Task1.mod(218,5));
     System.out.println(Task1.mod(6,3));

     System.out.println("Task11");
     System.out.println(Task2.oppositeHouse(1,3));
     System.out.println(Task2.oppositeHouse(2,3 ));
     System.out.println(Task2.oppositeHouse(3,5));
     System.out.println(Task2.oppositeHouse(5,46));

     System.out.println("Task12");
     System.out.println(Task2.nameShuffle("Donald", "Trump"));
     System.out.println(Task2.nameShuffle("Rosie", "O'Donnell"));
     System.out.println(Task2.nameShuffle("Seymour", "Butts"));

     System.out.println("Task13");
     System.out.println(Task2.discount(1500,50));
     System.out.println(Task2.discount(89,20));
     System.out.println(Task2.discount(100,75));

     System.out.println("Task14");
     System.out.println(Task2.differenceMaxMin(new double[] {10,4,1,4,-10,-50,32,21}));
     System.out.println(Task2.differenceMaxMin(new double[] {44,32,86,19}));

     System.out.println("Task15");
     System.out.println(Task2.equal(3,4,3));
     System.out.println(Task2.equal(1,1,1));
     System.out.println(Task2.equal(3,4,1));

     System.out.println("Task16");
     System.out.println(Task2.reverse("Hello World"));
     System.out.println(Task2.reverse("The quick brown fox."));
     System.out.println(Task2.reverse("Edabit is really helpful!"));

     System.out.println("Task17");
     System.out.println(Task2.programmers(147,33,526));
     System.out.println(Task2.programmers(33,72,74));
     System.out.println(Task2.programmers(1,5,9));

     System.out.println("Task18");
     System.out.println(Task2.getXO("ooxx"));
     System.out.println(Task2.getXO("xooxx"));
     System.out.println(Task2.getXO("ooxXm"));
     System.out.println(Task2.getXO("zpzpzpp"));
     System.out.println(Task2.getXO("zzoo"));

     System.out.println("Task19");
     System.out.println(Task2.bomb("There is a bomb."));
     System.out.println(Task2.bomb("Hey, did you think there is a BOMB?"));
     System.out.println(Task2.bomb("This goes boom!!!"));

     System.out.println("Task20");
     System.out.println(Task2.sameAscii("a","a"));
     System.out.println(Task2.sameAscii("AA","B@"));
     System.out.println(Task2.sameAscii("EdAbIt","EDABIT"));
    }
}
