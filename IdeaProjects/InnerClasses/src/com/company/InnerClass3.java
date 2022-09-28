package com.company;
class OuterClass1{
    int x =10;

    static class InnerClass{
        int y = 5;
    }
}
public class InnerClass3 {
    public static void main(String[] args){
        OuterClass1.InnerClass inner = new OuterClass1.InnerClass();
       System.out.println(inner.y);
    }
}
