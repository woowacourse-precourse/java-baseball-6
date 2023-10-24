package baseball.controller;

import baseball.model.Constant;
import baseball.view.Message;
import baseball.view.UserInput;
import baseball.view.UserOutput;

public class GameController {
    static public void gameProcessor(){
        UserOutput.consoleOutGameStart();
        /* play baseball game while user types "1" */
        do{
            GameService.gameStart();
        }while(restartGame());
    }

    static private boolean restartGame(){
        String userInput = UserInput.getUserInputGameResume();

        /* "1" -> re-start game, "2" -> exit game, others -> IllegalArgumentException */
        if(userInput.equals(Constant.RE_START_GAME)){
            return true;
        }
        else if(userInput.equals(Constant.EXIT_GAME)){
            return false;
        }
        else{
            throw new IllegalArgumentException(Message.INVALID_INPUT_RESUME_QUESTION);
        }
    }
}


