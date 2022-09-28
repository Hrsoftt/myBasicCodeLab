package academy.learn;

class Hamburger {
    private String name;
    private String meat;
    private double price;
    private String breadRollType;

    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
        System.out.println(name+" Hamburger on a "+breadRollType+" roll with "+meat+", price is "+price);

    }
    String addition1Name,addition2Name,addition3Name,addition4Name;
    double addition1Price,addition2Price,addition3Price,addition4Price;

    public void addHamburgerAddition1(String name, double price){
        addition1Name=name;
        addition1Price=price;
        System.out.println("Added "+name+" for an extra "+price);
    }

    public void addHamburgerAddition2(String name, double price){

        addition2Name=name;
        addition2Price=price;
        System.out.println("Added "+name+" for an extra "+price);
    }

    public void addHamburgerAddition3(String name, double price){
        addition3Name=name;
        addition3Price=price;
        System.out.println("Added "+name+" for an extra "+price);
    }

    public void addHamburgerAddition4(String name, double price){
        addition4Name=name;
        addition4Price=price;
        double totalPrice= this.price*price;
        System.out.println("Added "+name+" for an extra "+price);
    }

    public double itemizeHamburger(){
        return (addition1Price+addition2Price+addition3Price+addition4Price)+this.price;
    }

}
class DeluxeBurger extends Hamburger{

    public DeluxeBurger() {
        super("Deluxe","Sausage & Bacon",14.51,"White");

        System.out.println("Added Chips for an extra "+chipsPrice);
        System.out.println("Added Drink for an extra "+drinkPrice);

    }
    double chipsPrice = 2.79;
    double drinkPrice = 1.81;

    @Override
    public void addHamburgerAddition1(String name, double price) {

    }

    @Override
    public void addHamburgerAddition2(String name, double price) {

    }

    @Override
    public void addHamburgerAddition3(String name, double price) {

    }

    @Override
    public void addHamburgerAddition4(String name, double price) {

    }

    @Override
    public double itemizeHamburger() {
        //return super.itemizeHamburger();
        return (chipsPrice+drinkPrice)+14.54;
    }
}

class HealthyBurger extends Hamburger{
    public HealthyBurger(String meat, double price) {
        super("Healthy", meat, price,"Brown");
    }
    String healthyExtra1Name,healthyExtra2Name;
    double healthyExtra1Price,healthyExtra2Price;

    public void addHealthyAddition1(String name,double price){
       healthyExtra1Name = name;
       healthyExtra1Price = price;
        System.out.println("Added "+name+" for an extra "+price);
    }

    public void addHealthyAddition2(String name,double price){
        healthyExtra2Name = name;
        healthyExtra2Price = price;
        System.out.println("Added "+name+" for an extra "+price);
    }

    @Override
    public double itemizeHamburger() {
        return super.itemizeHamburger()+(healthyExtra1Price+healthyExtra2Price);
    }
}

public class Main {

    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("Basic", "Sausage", 3.56, "White");
        hamburger.addHamburgerAddition1("Tomato", 0.27);
        hamburger.addHamburgerAddition2("Lettuce", 0.75);
        hamburger.addHamburgerAddition3("Cheese", 1.13);
        System.out.println("Total Burger price is " + hamburger.itemizeHamburger());

        System.out.println("*************************************************8");

        DeluxeBurger db = new DeluxeBurger();
        db.addHamburgerAddition3("Should not do this", 50.53);
        System.out.println("Total Deluxe Burger price is " + db.itemizeHamburger());
        System.out.println("************************************************");

        HealthyBurger healthyBurger = new HealthyBurger("Bacon", 5.67);
        healthyBurger.addHamburgerAddition1("Egg", 5.43);
        healthyBurger.addHealthyAddition1("Lentils", 3.41);
        System.out.println("Total Healthy Burger price is  " + healthyBurger.itemizeHamburger());
    }
}
