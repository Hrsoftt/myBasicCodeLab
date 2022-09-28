package academy.learn;

public class SumChallenge {
    public static void main(String[] args) {
        int count =0;
        int sum =0;

        for (int i=1; i<=1000; i++){
            if((i%3==00)&&(i%5==0)){
                count++;
                sum+=i;
                System.out.println("Found number = "+ i);
            }

            if(count==5){
                System.out.println("Ending for loop");
                break;
            }
        }
        System.out.println("Sum = "+sum);
    }
}
