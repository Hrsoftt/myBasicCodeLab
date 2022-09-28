package academy.learn;

public class Main {

    public static void main(String[] args) {
	    Dog dog = new Dog("Spunky");
        dog.breathe();
        dog.eat();

        Parrot parrot = new Parrot("9ja Werey");
        parrot.breathe();
        parrot.fly();
        parrot.eat();
    }
}
