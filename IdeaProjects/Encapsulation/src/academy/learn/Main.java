package academy.learn;

public class Main {

    public static void main(String[] args) {
//	    Player player= new Player();
//        player.name="rash";
//        player.health=20;
//        player.weapon = "Sword";
//
//        int damage =10;
//        player.loseHealth(damage);
//        System.out.println("Remaining health = "+player.healthRemaining());
//
//        damage=11;
//        player.loseHealth(damage);
//        System.out.println("Remaining health = "+player.healthRemaining());
//        EnhancedPlayer enhancedPlayer =new EnhancedPlayer("Rash",200,"Sword");
//        System.out.println("Initial health is "+ enhancedPlayer.getHitPoint());
        Printer printer=new Printer(50,false);
        System.out.println("initial page count = "+printer.getPagesPrinted());
        int pagesPrinted=printer.printPages(4);
        System.out.println("Pages printed was "+ pagesPrinted+" new total print count for " +
                "printer= "+printer.getPagesPrinted());
        pagesPrinted=printer.printPages(5);
        System.out.println("Pages printed was "+ pagesPrinted+" new total print count for " +
                "printer= "+printer.getPagesPrinted());
        int toner = printer.addToner(51);
        System.out.println("Percentage of toner = "+toner+"%");

    }
}
