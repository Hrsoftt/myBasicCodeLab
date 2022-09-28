public class BreakAndContinue
{
   public static void main(String[] args)
   {
      int number = 143;
      System.out.println("Let's check if " + number + " is a prime number.");
      for (int divisor = 2; divisor < number; divisor++)
      {
         int remainder = number % divisor; //The modulo operator gives the remainder of the division involved.
         if (remainder == 0)
         {
            System.out.println("The number is not prime since it is divisible by " + divisor + ".");
            break;
         }
         if (divisor == number-1)
            System.out.println("The number is prime!");
      }

      System.out.println("\nLet's check how many factors it has.");
      int factor = 2;
      while (factor < number)
      {
         int remainder = number % factor; //The modulo operator gives the remainder of the division involved.
         factor++;
         if (remainder != 0)
         {
            continue;
         }
         System.out.println(factor-1 + " is a factor of 143.");
      }

   }
}