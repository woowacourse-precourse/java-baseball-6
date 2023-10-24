package baseball;

import static baseball.Constants.*;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    public GameController(){
        System.out.println(startGameMessage);
    }
    void runGame(){
        while (true) {
            Game baseBallGame = new Game();
            baseBallGame.play();
            if(askGameContinue()) return;
        }
    }
    boolean askGameContinue(){
        System.out.println(continueGameMessage);

        String continueCommand = Console.readLine();
        ExceptionHandler.raiseContinueCommandException(continueCommand);

        if (continueCommand.equals(gameStop)) {
            System.out.println(endGameMessage);
            return true;
        }
        return false;
    }
}
