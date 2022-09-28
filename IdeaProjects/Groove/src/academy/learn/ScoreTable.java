package academy.learn;

public class ScoreTable {
    public static void displayHighScorePosition(String playerName, int playerPosition){
        System.out.println(playerName + " managed to get into position " +playerPosition+ " on the high score table");
    }


    public static int calculatedHighScorePosition(int playerScore){
//        if (playerScore>=1000){
//            return 1;
//        }else if(playerScore >=500 ){
//            return 2;
//        }else if(playerScore >=100 ){
//            return 3;
//
//        }
//            return 4;

        int position = 4; // assuming position 4 will be returned
        if (playerScore >=1000){
            position=1;
        }else if(playerScore >=500){
            position=2;
        }else if(playerScore>=100){
            position=3;
        }

        return position;
    }

    public static void main(String[] args) {
       // displayHighScorePosition("Rasheed", 2);

        int playerPosition= calculatedHighScorePosition(1500);
        displayHighScorePosition("Tim ", playerPosition);

        playerPosition= calculatedHighScorePosition(900 );
        displayHighScorePosition("Bob ", playerPosition);

        playerPosition= calculatedHighScorePosition(400);
        displayHighScorePosition("Percy ", playerPosition);

        playerPosition= calculatedHighScorePosition(50);
        displayHighScorePosition("Gilbert ", playerPosition);


    }
}
