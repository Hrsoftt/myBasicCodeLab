package com.company;

public class Main {
    public static void main(String[] args){
        Car carl = new Car("Mazda", "8WD");

        Car.Engine engine = carl.new Engine();
        engine.setEngine();

        System.out.println("Engine type for 8WD = " + engine.getEngineType());

        Car car2 = new Car("Toyota","4WD");

        Car.Engine c2engine = car2.new Engine();
        c2engine.setEngine();
        System.out.println("Engine type for 4WD = " + c2engine.getEngineType());
    }
}
