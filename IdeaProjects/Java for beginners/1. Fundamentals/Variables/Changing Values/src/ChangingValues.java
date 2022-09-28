public class ChangingValues
{
   public static void main(String[] args)
   {
      int hoursInADay = 24;
      int workHours = 9;
      int sleepHours = 8;
      int freeHours = hoursInADay - (workHours + sleepHours);

      System.out.println("I have " + freeHours + " free hours per day.");

      workHours = workHours + 5;
      freeHours = hoursInADay - (workHours + sleepHours);

      System.out.println("I got a part time job.\nNow I have only " + freeHours + " free hours per day :(" );
   }
}
