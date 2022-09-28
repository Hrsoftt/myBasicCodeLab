package academy.learn;

import java.util.Scanner;

public class Main {
    private static Scanner scanner= new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        for (int i=0; i<myIntegers.length; i++){
            System.out.println("Element "+ i +", typed value was "+ myIntegers[i]);
        }
        System.out.println("The average is " + getAverage(myIntegers));

        //        int[] myIntArray = new int[25]; //{1,2,3,4,5,6,7,8,9,10};
//        //myIntArray[5]=50;
//        double[] myDoubleArray = new double[10];
//        //System.out.println(myIntArray[5]);
//        for (int i=0; i<myIntArray.length; i++){
//            myIntArray[i] =i*10;
//        }
//        printArray(myIntArray);
    }



    public static int[] getIntegers(int number){
        System.out.println("Enter "+ number+ " integer value.\r");
        int[] value = new int[number];
        for (int i=0; i<value.length;i++){
            value[i] = scanner.nextInt();
        }
        return value;
    }

    public static double getAverage(int[] array){
        int sum =0;
        for (int i=0; i<array.length;i++){
            sum +=array[i];
        }
        return (double) sum/(double) array.length;
    }
//    public static void printArray(int[] array){
//        for (int i=0; i<array.length; i++){
//            System.out.println("Element "+ i + ", value is "+array[i]);
//        }
//    }
}
