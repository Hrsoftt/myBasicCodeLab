package com.company;
class OuterClass4{
    String x = "Food";
    class InnerClass{
        String y ="Beans";
    }
}
public class Food {
    public static void main(String[] args ){
        OuterClass4 t = new OuterClass4();
        OuterClass4.InnerClass inner = t.new InnerClass();
        System.out.println(inner.y);
    }

}
