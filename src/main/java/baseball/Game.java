package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static GameInput gameInput = new GameInput();
    private static GameOutput gameOutput = new GameOutput();
    private static GameNumberComparator gameNumberComparator = new GameNumberComparator();
    private static GameNumberGenerator gameNumberGenerator = new GameNumberGenerator();
    public static void run(){
        Boolean isBegin = true;

        gameOutput.displayStartPrompt();
        List computerNumber = gameNumberGenerator.generateNumber();
        while (isBegin){


            gameOutput.displayInputNumberPrompt();
            List userNumber = gameInput.getUserNumber();
            int[] strikeAndBall = gameNumberComparator.compareNumbers(computerNumber, userNumber);
            int strike = strikeAndBall[0];
            int ball = strikeAndBall[1];

            gameOutput.displayHint(strike, ball);
            if (strike == 3){
                gameOutput.displayQuitPrompt();
                gameOutput.displayResumePrompt();
                Boolean restart = gameInput.getRestartOption();
                if (!restart){
                    isBegin = false;
                } else{
                    computerNumber = gameNumberGenerator.generateNumber();
                }
            }

        }
    }

}
