package academy.learn;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Jeo");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> manU = new Team<>("Chicago Bulls");
        manU.addPlayer(joe);
//        manU.addPlayer(pat);
//        manU.addPlayer(beckham);

        System.out.println(manU.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Norwich");
        baseballTeam.addPlayer(pat);

        Team<SoccerPlayer> soccerTeam = new Team<>("ManU");
        soccerTeam.addPlayer(beckham);

        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPlayer(banks);

        Team<FootballPlayer> hawthorn =new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");

        hawthorn.matchResult(fremantle,1,0);
        hawthorn.matchResult(manU,3,8);

        manU.matchResult(fremantle,2,1);
        //soccerTeam.matchResult(baseballTeam,1,1);

        System.out.println("Ranking");
        System.out.println(manU.getName() + ": "+manU.ranking());
        System.out.println(melbourne.getName() + ": "+melbourne.ranking());
        System.out.println(fremantle.getName() + ": "+fremantle.ranking());
        System.out.println(hawthorn.getName() + ": "+hawthorn.ranking());
        System.out.println(manU.compareTo(melbourne));
        System.out.println(manU.compareTo(hawthorn));
        System.out.println(hawthorn.compareTo(manU));
        System.out.println(melbourne.compareTo(fremantle));












//        ArrayList<Integer> items = new ArrayList<>();
//        items.add(1);
//        items.add(2);
//        items.add(3);
//        items.add(4);
//
//        printDoubled(items);
    }

//    public static void printDoubled(ArrayList<Integer> n){
//        for (int i : n){
//            System.out.println(i *2);
//        }
//    }
}
