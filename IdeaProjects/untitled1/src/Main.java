import java.util.*;
import java.util.function.Consumer;
public class Main {
    public static void main(String[]args){
        ArrayList<Integer>numbers=new ArrayList<>();
        numbers.add(5);
        numbers.add(6);
        numbers.add(8);
        numbers.add(10);
        Consumer<Integer>method=(n)->{System.out.println(n);};
        numbers.forEach(method);
    }
}
