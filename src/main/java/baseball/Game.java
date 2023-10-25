package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static GameInput gameInput = new GameInput();
    private static GameOutput gameOutput = new GameOutput();
    private static GameNumberComparator gameNumberComparator = new GameNumberComparator();
    private static GameNumberGenerator gameNumberGenerator = new GameNumberGenerator();
    public void run(){
        Boolean isBegin = true;

        gameOutput.displayStartPrompt();
        gameNumberGenerator.generateNumber();
        while (isBegin){
            gameOutput.displayInputNumberPrompt();
            List userNumber = gameInput.getUserNumber();
            gameNumberComparator.compareNumbers(gameNumberGenerator.gameNumber, userNumber);
            gameOutput.displayHint(gameNumberComparator.strike, gameNumberComparator.ball);

            isBegin = handleThreeStrikesWithOption(checkOption(checkThreeStrikes()));
        }
    }
    public static boolean checkThreeStrikes(){
        if (gameNumberComparator.strike == 3){
            gameOutput.displayQuitPrompt();
            return true;
        } else{
            return false;
        }
    }
    public static int checkOption(boolean isThreeStrikes){
        if (isThreeStrikes){
            gameOutput.displayResumePrompt();
            return gameInput.getRestartOption();
        }else {
            return 3;
        }
    }
    public static boolean handleThreeStrikesWithOption(int option){
        if (option == 1){
            gameNumberGenerator.generateNumber();
            return true;
        }
        else if(option == 2){
            return false;
        }
        else if(option == 3){
            return true;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

}
