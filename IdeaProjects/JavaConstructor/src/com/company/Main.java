package com.company;

public class Main {
    int modelYear;
    String modelName;

    public Main(int year, String name){
        modelYear=year;
        modelName=name;

    }

    public static void main(String[] args) {
	    Main myCar=new Main(2010,"Toyota");
        System.out.println(myCar.modelYear +" "+myCar.modelName);
    }
}
