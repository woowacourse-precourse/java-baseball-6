package baseball.game;

import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.util.InputManager;
import baseball.util.PrintMessage;

public class BaseballGame{

    public static void play() throws IllegalArgumentException{
        PrintMessage.printStartMessage();
        InputManager inputManager = new InputManager();

        Computer computer;
        Player player;
        GameResult result;

        while(true){
            computer = new Computer();

            while(true){
                PrintMessage.printInputStartMessage();
                player = new Player(inputManager.getPlayerInputNumbers());
                result = new GameResult(computer, player);
                PrintMessage.printHint(result);
                if(result.isRight()){
                    PrintMessage.printSuccessMessage();
                    break;
                }
            }

            if(!inputManager.checkUserContinue()){
                break;
            }
        }
    }
}
