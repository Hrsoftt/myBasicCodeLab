public class BooleanLogic
{
   public static void main(String[] args)
   {
      boolean value1, value2;
      value1 = true;
      value2 = !value1;
      boolean result = (!value1||value1)||(value1&&!value2);
   }
}