package com.company;

public class C {
    public static void main(String[]args){
        int a = 5;
        A s =(int x)->x*x;
        int ans = s.calculate(a);
        System.out.println(ans);
    }
}
