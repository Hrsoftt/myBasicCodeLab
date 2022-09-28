public class calc {

    public static double  calcFeetAndInchesToCentimeter(double feet,double inches){

        if(feet <0 || inches<0 || inches>12){
            System.out.println("invalid feet or inches parameter");
            return -1;

        }
        double centimeters = (feet*12)*2.54;
        centimeters +=inches*2.54;
        System.out.println(feet + " feet, "+ inches +" inches = "
            + centimeters+ " cm");
        return centimeters;
    }

    public static double  calcFeetAndInchesToCentimeter(double inches){

        if(inches <0){
            return -1;
        }
        double feet = (int)inches /12;
        double remainingInches= (int)inches%12;
        System.out.println(inches +" inches = "+feet+ " feet and "+remainingInches);
        return calcFeetAndInchesToCentimeter(feet,remainingInches);
    }


    public static void main(String[] args) {
        calcFeetAndInchesToCentimeter(7,5);

        calcFeetAndInchesToCentimeter(100);
    }
}