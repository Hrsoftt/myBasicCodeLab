package academy.learn;

public class EvenNumber {
    public static boolean isEvenNumber(int a){
        return a%2==0;
    }

   /* public static void main(String[] args) {
        int number =4;
        int finishNumber = 20;

        while(number <= finishNumber){
            number++;
            if(!isEvenNumber(number)){
                continue;
            }
            System.out.println("Even number "+number);
        }
    }*/

    public static void main(String[] args) {
        int number =4;
        int finishNumber = 20;
        int evenNoFound=0;


        while(number <= finishNumber){
            number++;
            if(!isEvenNumber(number)){
                continue;
            }
            System.out.println("Even number "+number);
            evenNoFound++;
            if(evenNoFound>=5){
                break;
            }

        }
        System.out.println("Total even number found = "+evenNoFound);
    }
}
