package com.company;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> personList=new ArrayList<>();

        personList.add(new Person("Paul",24));
        personList.add(new Person("Vicky",28));
    }
  /*  public static int compareByName(Person a,Person b ){
        return a.getName().compareTo(b.getName());
    }*/


}

