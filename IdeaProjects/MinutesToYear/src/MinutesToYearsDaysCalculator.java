public class MinutesToYearsDaysCalculator {

    public static void printYearsAndDays(long minutes){
        if(minutes<0){
            System.out.println("Invalid Value");

        }else {
            long year = (minutes /(365*24*60));
            long day = (minutes/(60*24))%365;
            System.out.println(minutes+" min "+ year + " y " +" and " + day + "d");
        }
    }


}
