package com.company;

import java.util.Arrays;
import java.util.List;

public class FunctionalPro {
    public static void main(String[] args){
        List<Integer> numbers= Arrays.asList(11,22,33,44,55,66,77);
        for(Integer n : numbers){
            System.out.println(n);
        }
    }
}
