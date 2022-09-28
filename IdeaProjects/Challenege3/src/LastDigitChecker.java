public class LastDigitChecker {
    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(41,22,71));
        System.out.println(isValid(1));
    }


    public static boolean hasSameLastDigit(int Num1, int Num2, int Num3){
        if((Num1>=10 && Num1 <=1000)&&(Num2>=10 && Num2<=1000) && (Num3>=10 && Num3<=1000)){
            int numRemainder1=Num1%10;
            int numRemainder2=Num2%10;
            int numRemainder3=Num3%10;
            if(numRemainder1==numRemainder2||numRemainder1==numRemainder3||numRemainder2==numRemainder3||(numRemainder1==numRemainder2&&numRemainder1==numRemainder3&&numRemainder2==numRemainder3)){
                return true;
            }

        }return false;
    }

    public static boolean isValid(int a){
        return a>=10&&a<=1000;
    }
}
