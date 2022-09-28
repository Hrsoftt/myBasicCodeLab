package academy.learn;

class Car{
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name ) {
        this.name = name;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.engine = true;
    }


    public String startEngine(){
        return "car's engine is starting ";
    }

    public String accelerate(){
        return "car is accelerating";
    }

    public String brake(){
        return "car is breaking";
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}

class Benz extends Car{
    public Benz( int cylinder,String name) {
        super(cylinder,name);
    }

    @Override
    public String startEngine() {
        return getClass().getSimpleName()+" ->startEngine";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName()+"  -> accelerate()";
    }

    @Override
    public String brake() {
        return getClass().getSimpleName()+"  -> break()";
    }
}
 class Ford extends Car {
     public Ford(int cylinders,String name) {
         super(cylinders,name);
     }

     @Override
     public String startEngine() {
         return getClass().getSimpleName()+" ->startEngine";
     }

     @Override
     public String accelerate() {
         return getClass().getSimpleName()+"  -> accelerate()";
     }

     @Override
     public String brake() {
         return getClass().getSimpleName()+"  -> break()";
     }
 }

 class Toyota extends Car{
    public Toyota(int cylinder,String name) {
        super(cylinder,name );
    }

    @Override
    public String startEngine() {
        return getClass().getSimpleName()+" ->startEngine";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName()+"  -> accelerate()";
    }

    @Override
    public String brake() {
        return getClass().getSimpleName()+"  -> break()";
    }

}

public class Main {

    public static void main(String[] args) {
	    Benz benz =new Benz(6,"Benz");
        System.out.println(benz.startEngine());
        System.out.println(benz.accelerate());
        System.out.println(benz.brake());

        Ford ford=new Ford(6,"Ford");
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

    }



}
