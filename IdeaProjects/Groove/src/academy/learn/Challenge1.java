package academy.learn;

public class Challenge1 {

    public static void main(String[] args) {
        double num1= 20.00 ;
        double num2= 80.00;
        double addNum = (num1+num2)*100;
        System.out.println("Total "+ addNum);
        double remainder = addNum % 40;
        System.out.println(remainder);

        boolean zeroRemainder = (remainder == 0)? true:false;
        System.out.println("ZeroRemainder " +zeroRemainder);

        if (zeroRemainder){
            System.out.println("The remainder is zero!");
        }



    }
}
