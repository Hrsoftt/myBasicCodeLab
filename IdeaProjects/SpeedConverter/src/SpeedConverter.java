public class SpeedConverter {
    public static long toMilesPerHour(double kilometersPerHour){
        if (kilometersPerHour <0){
            return -1;
        }
         return Math.round(kilometersPerHour/1.609);

    }


    public static void printConversion(double kilometersPerHours){
        if (kilometersPerHours <0){
            System.out.println("Invalid value");
        }else {
            long milesPerHour = toMilesPerHour(kilometersPerHours);
            System.out.println(kilometersPerHours +" km/h = "+milesPerHour +" mi/h");
        }
    }
}
