package academy;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumElement {

    public static void main(String[] args) {
//        int count = readIntegers();
//        System.out.println(count);
        int[] myIntegers = readElements(readIntegers());
        System.out.println("myIntegers "+Arrays.toString(myIntegers));
       System.out.println("Minimum = "+findMin(myIntegers));
    }

    public static int readIntegers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter number of elements in array: ");
        int count = scanner.nextInt();

        return count;
    }

    public static int[] readElements(int elements){
        System.out.println("Enter "+elements+" numbers: \r");
        Scanner scanner = new Scanner(System.in);
        int[] array =new int[elements];

        for(int i=0; i<array.length;i++){
            array[i]=scanner.nextInt();
        }return array;
    }
    public static int findMin(int[] array){
        int min =array[0];
        for (int i=0; i<array.length;i++){
            if(array[i]<min){
                min =array[i];
            }
        }return min;
    }
}
