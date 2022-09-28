public class NumberToWords {
    public static void main(String[] args) {
        numberToWords(546);
       // System.out.println(reverse(123));
    }

    public static void numberToWords(int number){
       if(number<0){
           System.out.println("Invalid Value");
       }
       int countOfDigits= getDigitCount(number);
       int countOfWhile=0;
       int reversedValue= reverse(number);
       while (reversedValue>0){
        int lastValue = reversedValue%10;


           switch (lastValue){
               case 0:
                   System.out.println("Zero");
                   break;
               case 1:
                   System.out.println("One");
                   break;
               case 2:
                   System.out.println("Two");
                   break;
               case 3:
                   System.out.println("Three");
                   break;
               case 4:
                   System.out.println("Four");
                   break;
               case 5:
                   System.out.println("Five");
                   break;
               case 6:
                   System.out.println("Six");
                   break;
               case 7:
                   System.out.println("Seven");
                   break;
               case 8:
                   System.out.println("Eight");
                   break;
               case 9:
                   System.out.println("Nine");
                   break;
           }
           countOfWhile++;
           reversedValue/=10;
       }
       for(int i=countOfWhile; i <countOfDigits; i++) {
           System.out.println("Zero");
       }
    }

    public static int reverse(int number){

        int reverse=0;
        while(number!=0){
            reverse = reverse*10 +number%10;
            number/=10;


        }

        return reverse;
    }

    public static int getDigitCount(int number){
        if(number<0){
            return -1;
        }
        if(number==0){
            return 1;
        }
        int count =0;
        while(number > 0){
            number/=10;
            count++;
        }return count;
    }
}
