package com.company;

public class Car {
    String carName;
    String carType;

    public Car(String name, String type){
        this.carName =name;
        this.carType =type;

    }
    private String getCarName(){
        return this.carName;
    }
    //innerClass
    class Engine{
        String engineType;
        void setEngine(){
            //Accessing the CarType property
            if(Car.this.carType.equals("4WD")){
                //invoking method getCarName() of car
                if(Car.this.getCarName().equals("Toyota")){
                    this.engineType ="Smaller";
                }else{
                    this.engineType ="Bigger";
                }

            }else{
                this.engineType = "Bigger";
            }
        }
        String getEngineType(){
            return this.engineType;
        }
    }
}
