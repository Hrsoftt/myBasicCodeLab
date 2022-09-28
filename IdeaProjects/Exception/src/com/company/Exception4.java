package com.company;

public class Exception4 {
    static void func(int a)
       throws Exception6 {
            System.out.println(10/a);
        }
    public static void main(String[]args){
        try{
            func(10);
            func(0);
        }catch (Exception6 e){
            System.out.println("Can't divid");
        }
    }
}
