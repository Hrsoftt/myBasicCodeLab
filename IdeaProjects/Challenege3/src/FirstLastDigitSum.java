public class FirstLastDigitSum {
    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigits(10));
    }
    public static int sumFirstAndLastDigits(int number){
      int lastDigit=0;

      if (number>=0) {
          lastDigit = number % 10;


          while (number > 9) {
              number /= 10;
          }
          return number+lastDigit;
      }
          return -1;

    }
}
