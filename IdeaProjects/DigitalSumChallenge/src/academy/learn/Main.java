package academy.learn;

public class Main {

    public static void main(String[] args) {
        System.out.println("The sum of digits in number 125 is "+sumDigits(125));
    }

    static int sumDigits(int number){
        if(number<10){
            return -1;
        }

        int sum =0;
        while (number >0){
            //extract the lest-significant digit
            System.out.println("number of times "+ number);
            int digit=number%10;
            System.out.println(digit);
            sum+=digit;

            //drop the least-significant digit
            number/=10; //same as number = number /10;
        }
        return sum;
    }
}
