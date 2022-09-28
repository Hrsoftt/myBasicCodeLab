package com.company;

public class Exception3 {
    static void canVote(int age){
        if(age<18){
            try{
                throw new Exception6();
            }catch (Exception6 e){
                System.out.println("You are not an adult");
            }

        }else{
            System.out.println("You can vote");
        }

    }
    public static void main(String[]args){
        canVote(20);
        canVote(10);
    }
}
