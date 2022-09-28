package com.company;
class OuterClass {
    int x = 10;
    class InnerClass{
        int y =5;
    }
}
public class InnerClass2 {
    public static void main(String[] args ){
        OuterClass t = new OuterClass();
        OuterClass.InnerClass inner = t.new InnerClass();
        System.out.println(inner.y +t.x);
    }
}
