package com.company;
import java.util.ArrayList;
import java.util.function.Consumer;

public class test {



        /*public static void main(String[] args) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            numbers.add(5);
            numbers.add(9);
            numbers.add(8);
            numbers.add(1);
            numbers.forEach( (n) -> { System.out.println(n); } );
        }*/
        /*static void myMethod(String fname, int age) {
            System.out.println(fname + " is " + age);
        }
        static int num(int x, int y){
            return x+y;
        }*/
        static void checkAge(int age){

            if (age < 18){
                System.out.println("Sorry you'er not old enough");
            }
            else{
                System.out.println("Welcome: you are old enough");
            }
        }
        public static void main(String[] args) {
            //System.out.println(num(5,6));
            checkAge(20);
            int result = sum(10,3);





            /*ArrayList<Integer> numbers = new ArrayList<Integer>();
            numbers.add(5);
            numbers.add(9);
            numbers.add(8);
            numbers.add(1);
            Consumer<Integer> method = (n) -> {
                System.out.println(n);
            };
            numbers.forEach(method);
           String num = (10<2)? "10 is lesser" : "10 is greater";
           System.out.println(num);
            int day = 5;
            switch (day) {
                case 1:
                    System.out.println("Monday");
                    break;
                case 2:
                    System.out.println("Tuesday");
                    break;
                case 3:
                    System.out.println("Wednesday");
                    break;
                case 4:
                    System.out.println("Thursday");
                    break;
                case 5:
                    System.out.println("Friday");
                    break;
                case 6:
                    System.out.println("Saturday");
                    break;
                case 7:
                    System.out.println("Sunday");
                    break;

            }
            int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
            int x = myNumbers[0][2];
            System.out.println(x);




                myMethod("Liam", 18);
                myMethod("Jenny", 23);
                myMethod("Anja", 30);*/


        }
}
