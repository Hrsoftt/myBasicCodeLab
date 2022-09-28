package com.company;
import java.util.*;
import java.util.function.Consumer;

public class ClassWork {
    public static void main(String[]args){
        ArrayList<String> color=new ArrayList<>();
        color.add("red");
        color.add("blue");
        color.add("yellow");
        color.add("green");
        Consumer<String>method=(n)->{System.out.println(n);};
        color.forEach(method);

    }
}
