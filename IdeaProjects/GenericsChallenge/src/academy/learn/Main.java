package academy.learn;

public class Main {

    public static void main(String[] args) {
	    League<Team<FootballPlayer>> footballLeague = new League<>("EPL");
        Team<FootballPlayer> manU = new Team<>("Chicago Bulls");
        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        Team<FootballPlayer> hawthorn =new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");
        Team<BaseballPlayer> baseballTeam = new Team<>("Norwich");

        hawthorn.matchResult(fremantle,1,0);
        hawthorn.matchResult(manU,3,8);

        manU.matchResult(fremantle,2,1);

        footballLeague.add(manU);
        footballLeague.add(melbourne);
        footballLeague.add(hawthorn);
        footballLeague.add(fremantle);

        //footballLeague.add(baseballTeam);
        footballLeague.showLeagueTable();

    }
}
