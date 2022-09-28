
public class SharedDigit {
    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12,32));
    }

    public static boolean hasSharedDigit(int a,int b){

        if((a>=10 &&a<=99) && (b>=10&&b<=99)){

            while(a>0&&b>0){
                 int remainderA=a%10;
                int remainderB =b%10;

                if(remainderA==b/10||remainderB==a/10||remainderB==remainderA){
                    return true;
                }

                a/=10;
                b/=10;


            }

        }

       return false;
    }
}