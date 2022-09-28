package com.company;

public class Main {


    public static void main(String[] args) {
	    Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("I have an A grade");
            }
        };
        r.run();
        System.out.println("I have an A");
    }
}
