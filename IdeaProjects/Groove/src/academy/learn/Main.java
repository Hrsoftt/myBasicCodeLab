package academy.learn;

public class Main {

    public static void main(String[] args) {

        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;
        System.out.println("Integer Minimum Value = " + myMinIntValue);
        System.out.println("Integer Maximum Value = " + myMaxIntValue);
        System.out.println("Busted Max Value = " +(myMaxIntValue +1));

       byte Num1 =  37;
       short Num2 = 3233;

       long Num3 = 50000l + 10 *(Num1 + Num2);
        System.out.println("Long " + Num3);
        double pound = 500, Kilo = 0.45359237;

        double kilogram =   pound* Kilo;
        System.out.println("500 Pound is = " +kilogram +"kg");



    }
}
