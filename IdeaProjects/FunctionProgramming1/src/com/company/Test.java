package com.company;



import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Test {
    public static void main(String[]args){
        List<String>names= Arrays.asList("Grace", "Paul","Kendrick");
        Predicate<String> p =(s) ->s.startsWith("P");
        for (String st:names){
            if (p.test(st)){
                System.out.println(st);
            }
        }
    }
}
