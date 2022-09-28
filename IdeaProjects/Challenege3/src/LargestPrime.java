public class LargestPrime {

    public static void main(String[] args) {
        System.out.println(getLargestPrime(217));
    }

    public static  int getLargestPrime(int number){

        if (number<=1){
            return -1;
        }
        int num=0;
        int count=2;
        while (count<number){

            if(number%count!=0){
                num =count;

                count++;

            }else {
                number/=count;
            }

        }return number;

    }
}
