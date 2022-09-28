package com.company;

public interface Schedule {
    default void wakeUp(){
        checkTime(12);
    }
    default void haveBreakfast(){
        checkTime(5);
    }
    default void havLunch(){
        checkTime(7);
    }
    default void workout(){
        checkTime(9);
    }
    private void checkTime(int hour){
        if (hour>17){
            System.out.println("You are late");

        }else {
            System.out.println("You have " +(17-hour)+ " hours left + " +"to make the appointment" );
        }
    }
}
