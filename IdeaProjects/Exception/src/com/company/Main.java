package com.company;

public class Main {

    public static void main(String[] args){
        try{
            int[] myNum = {1, 2, 3};
            System.out.println(myNum[10]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Something went wrong");
        }
    }
}
