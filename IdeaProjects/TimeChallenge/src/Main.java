public class Main {
    private static final String INVALID_VALUE_MESSAGE = "Invalid value";
    public static String getDurationString(int minutes, int seconds){

        if(minutes<0 || seconds <0 || seconds>59){
             return INVALID_VALUE_MESSAGE;
        }
            int hour= minutes/60;
            int hourRemainder = minutes%60;

            String hourString= hour +"h";
            if (hour<10){
                hourString= "0" +hourString;
            }

        String minutesString= hourRemainder +"m";
        if (hourRemainder<10){
            minutesString= "0" +minutesString;
        }

        String secondsString= seconds +"s";
        if (seconds<10){
            secondsString= "0" +secondsString;
        }
            return hourString +" "+minutesString+ " "+ secondsString + " ";

    }


    public static String getDurationString( int seconds){
        if(seconds<0){
            return INVALID_VALUE_MESSAGE;
        }
            int min=seconds/60;
            int minRemainder = seconds%60;
            return getDurationString(min,minRemainder);

    }

    public static void main(String[] args) {
        System.out.println (getDurationString(500,20));
        System.out.println(getDurationString(3945));
    }
}
