package com.company;

public class Second {
    public static void main(String[]args){
        /*JavaClass s=new JavaClass();
        s.x=10;
        System.out.println(s.x);*/
        //create an object of student class(which inherits attributes and methods from Main)
        Student myObj = new Student();
        System.out.println("Name: "+myObj.fname);
        System.out.println("Age: "+myObj.age);
        System.out.println("Graduation Year: "+myObj.graduationYear);
        myObj.study();// call abstract method
    }
}
