public class Car
{
   private String model;
   private boolean isElectric;
   private double price;

   public Car(String type, boolean runsOnBatteries, double cost)
   {
      model = type;
      isElectric = runsOnBatteries;
      price = cost;
   }
}