package com.company;

public class ExceptionDemo {
    public static void main(String[] args){
        int a=10;
        for(int i=3; i>0; i--){
            //try{
                float c = a/i;
                System.out.println(c);
            //}catch (ArithmeticException e){
               // System.out.println(e);
            }
        }
    }

