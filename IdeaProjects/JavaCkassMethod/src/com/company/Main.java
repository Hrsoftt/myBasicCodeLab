package com.company;

public class Main {
    static void myMethod(){
        System.out.println("Hello World!");

    }

    public  void publicMethod(){
        System.out.println("Public must be called by creating object");
    }
    public void fullThrottle(){
        System.out.println("The car is going fast as it can!");
    }
    public void speed(int maxSpeed){
        System.out.println("Max speed is: " +maxSpeed);
    }

    public static void main(String[] args) {
        myMethod();
        Main Pub=new Main();
        Main myCar=new Main();
        Pub.publicMethod();
        myCar.fullThrottle();
        myCar.speed(200);

    }
}
