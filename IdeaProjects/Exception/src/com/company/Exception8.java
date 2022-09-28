package com.company;

public class Exception8{
    public static void main(){
        try{
            System.out.println(4/0);
        }catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("Finally executed");
        }
        System.out.println("end");
    }
}
