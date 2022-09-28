package com.company;

public class NestedClasses2 {
    static class Nested{
        private int price=6;
    }
    public static void main(String[]args){
        Nested n = new Nested();
        System.out.println(n.price);
    }
}
