package com.company;

public class Bunny implements Hop{
    public double printDetails(){
        System.out.println(Hop.getJumpHeight());
        return 8;
    }
    public static void main(String[]args){
        System.out.println(new Bunny().printDetails());
    }
}
