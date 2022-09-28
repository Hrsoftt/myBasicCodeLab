public class EvenDigitSum {

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(123456789));
    }

    public static int getEvenDigitSum(int number){

        int totalEvenNumber=0;
        if (number>=0){

             while (number!=0){
                 int even = number%10;
                 System.out.println("Even "+even);
                 if (even%2==0){
                     totalEvenNumber+=even;
                 }

                 number/=10;
                 System.out.println(number);
             }
            return totalEvenNumber;
        }return -1;
    }
}
