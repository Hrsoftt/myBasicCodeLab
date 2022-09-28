interface Product{
    float multi(float x, float y);
}

public class LambdaExample {
    public static void main(String[] args){
        Product multi1=(x,y)->(x*y);
        System.out.println(multi1.multi(2,9));

        Product multi2=(float x,float y)->(x*y);
        System.out.println(multi2.multi(100,200));
    }
}
