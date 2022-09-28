package com.company;

public class PrintNumbers {
    private int length = 5;
    public void calculator(){
        final int width=20;
        class myLocalClass{
            public void multiply(){
                System.out.println(length*width);
            }
        }
        myLocalClass l =new myLocalClass();
        l.multiply();
    }
    public static void main(String[]args){
        PrintNumbers n =new PrintNumbers();
        n.calculator();
    }
}
