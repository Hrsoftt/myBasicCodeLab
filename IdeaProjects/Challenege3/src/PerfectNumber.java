public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println(isPerfectNumber(5));
    }

    public static boolean isPerfectNumber(int number) {
        int total = 0;

        if (number > 0) {

            for (int i = 1; i < number; i++) {
                if(number%i==0){
                    total+=i;
                    //System.out.println(total);

                }

            }
            return total==number;
        }return false;

    }
}