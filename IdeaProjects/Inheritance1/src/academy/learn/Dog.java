package academy.learn;

public class Dog extends Animal{

    private int eye;
    private int legs;
    private int tail;
    private int teeth;
    private String coast;

    public Dog(String name, int size, int weight, int eye,int legs,int tail,int teeth,String coast) {
        super(name, 1, 1, size, weight);
        this.eye=eye;
        this.legs=legs;
        this.tail=tail;
        this.teeth=teeth;
        this.coast=coast;
    }
    private void chew(){
        System.out.println("Dog.chew() called");
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat() called");
        chew();
        super.eat();
    }
    public void walk(){
        System.out.println("Dog.walk() called");
        super.move(5);
    }
    public void run(){
        System.out.println("Dog.run() called");
        move(10);
    }

    private void moveLegs(int speed){
        System.out.println("Dog.moveLegs() called");
    }
    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called");
        moveLegs(speed);
        super.move(speed);
    }
}
