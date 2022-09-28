import java.util.*;


public class Fruits {
    public static void main(String[]args){
        List<String> list=new ArrayList<String>();
        list.add("Apple");
        list.add("Grape");
        list.add("Orange");
        list.add("Banana");

        list.forEach((n)->System.out.print(n));
    }
}
