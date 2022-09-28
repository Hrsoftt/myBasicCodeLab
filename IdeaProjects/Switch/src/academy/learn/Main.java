package academy.learn;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        char myCharValue= 'A';
        switch (myCharValue){
            case 'A':
                System.out.println("its A");
                break;
            case 'B':
                System.out.println("its B");
                break;
            case 'C': case 'D':
                System.out.println("its C");
                break;
            default:
                System.out.println("Non was found");
        }
        String month= "January";
        switch (month.toLowerCase()){
            case "january":
                System.out.println("Jan");
                break;
            case "june":
                System.out.println("Jun");
                break;

        }

    }
}
