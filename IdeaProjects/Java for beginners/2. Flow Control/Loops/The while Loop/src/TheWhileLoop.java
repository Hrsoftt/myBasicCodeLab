public class TheWhileLoop
{
   public static void main(String[] args)
   {
      int counter = 0;

      while (counter < 10 )
      {
         System.out.println("counter value is " + counter);
         System.out.println("I'm going to be printed a limited number of times.");
         counter++;
      }
      /*
      while (counter >= 0) //uncomment to run this example
      {
         System.out.println("counter value is " + counter);
         System.out.println("I am stuck in an endless loop!");
      }
      */
   }
}