package baseball;

import static baseball.Constants.*;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    public GameController(){
        System.out.println(SystemMessage.STARTGAME.get());
    }
    void runGame(){
        while (true) {
            Game baseBallGame = new Game();
            baseBallGame.play();
            if(askGameContinue()) return;
        }
    }
    boolean askGameContinue(){
        System.out.println(SystemMessage.CONTINUEGAME.get());

        String continueCommand = Console.readLine();
        ExceptionHandler.raiseContinueCommandException(continueCommand);

        if (continueCommand.equals(SystemMessage.GAMESTOP.get())) {
            System.out.println(SystemMessage.ENDGAMEM.get());
            return true;
        }
        return false;
    }
}
