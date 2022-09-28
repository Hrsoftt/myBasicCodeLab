public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces(
            double Num1, double Num2){
        Num1= (int) (Num1*1000);
        Num2= (int) (Num2*1000);

        if(Num1==Num2){
            return true;
        }return false;
    }
}
