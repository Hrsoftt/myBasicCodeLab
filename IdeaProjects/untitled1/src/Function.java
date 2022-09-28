interface Statement{
    public String greet();
}

public class Function {
    public static void mai(String[] args){
        Statement s=()->{
            return "Hello World";

        };
        System.out.println(s.greet());
    }
}
