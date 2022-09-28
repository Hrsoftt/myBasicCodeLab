import java.util.*;

public class Student1{
    //Comparator<Developer>byName=(Developer o1,Developer o2)->o1.getName().compareTo(o2
    int rollNo;
    String name;
    public Student1(int rollNo,String name){
        super();
        this.rollNo=rollNo;
        this.name=name;

    }

    //public class LambdaExpression{
    public static void main(String[]args){
        List<Student1>list=new ArrayList<Student1>();
        list.add(new Student1(1,  "Ndidi"));
        list.add(new Student1(2,  "Paul"));
        list.add(new Student1(3 , "John"));
        System.out.println("Sorting on the basics of name.......");
        Collections.sort(list,(o1,o2)->{return o1.name.compareTo(o2.name);});
        for(Student1 student:list){
            System.out.println(student.rollNo+ "," +student.name);
        }
   }
}