package academy.learn;

import java.util.Scanner;

public class Main {
private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("enter number of elements in array: ");
        int count = scanner.nextInt();
	    int[] myIntegers = readIntegers(count);
        System.out.println("Minimum value: "+findMin(myIntegers));


    }

    public static int[] readIntegers(int count){
        int[] array= new int[count];
        System.out.println("Enter "+count+" numbers: \r");
        for (int i=0;i<array.length; i++){
            array[i]=scanner.nextInt();
        }return array;
    }

    public static int findMin(int[] array){
        int min = Integer.MAX_VALUE;
        for (int i=0; i<array.length;i++){
            if (array[i]<min){
                min=array[i];
            }
        }
        return min;
    }
}
