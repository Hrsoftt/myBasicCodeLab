public class ShortcutOperators
{
   public static void main(String[] args)
   {
      int x = 1, y = 3, z = -2;
      x++;
      System.out.println("x is now " + x);
      z--;
      System.out.println("z is now " + z);
      y += x;
      System.out.println("y is now " + y);
      z *= x-y;
      System.out.println("z is finally " + z);
   }
}