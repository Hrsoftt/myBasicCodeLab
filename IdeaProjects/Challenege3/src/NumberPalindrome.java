public class NumberPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int number){


        int num =number;
        int reverse = 0;

        while (number!=0){

            int lastDigit = number%10;
            reverse *= 10;
            System.out.println("this "+reverse);
            reverse+=lastDigit;

            number/=10;




        }
        if(reverse==num){
            return true;
        }return false;
    }

}
