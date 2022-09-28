package com.company;

/*public class JavaClass {
    int x =5;
    int y =3;
   /* public static void main(String[]args){
        JavaClass myObj= new JavaClass();
        System.out.println(myObj.x);

    }*/
    //abstract class
    abstract class JavaClass{
        public String fname = "John";
        public int age = 20;
        public abstract void study();
    public int graduationYear = 2018;
   }
   // Subclass (inherit from Main)
   class Student extends JavaClass{

       public void study(){
           System.out.println("Studying all day");
           System.out.println();
       }
   }

//}
