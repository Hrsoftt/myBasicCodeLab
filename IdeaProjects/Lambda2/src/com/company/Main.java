package com.company;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
            ArrayList<Integer>numbers=new ArrayList<>();
            numbers.add(5);
            numbers.add(6);
            numbers.add(7);
        Consumer<Integer>method = (n)-> {System.out.println(n);};
        numbers.forEach(method);
    }
}
