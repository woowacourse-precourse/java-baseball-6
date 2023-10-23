package baseball.core;

import baseball.generator.ComputerNumberGenerator;
import baseball.generator.ResultGenerator;
import baseball.handler.GameHandler;
import baseball.handler.UserInputHandler;
import baseball.validator.InputValidator;
import baseball.view.OutputView;

public class BaseballGame {
    private final GameHandler gameHandler;

    public BaseballGame (){
        UserInputHandler userInputHandler = new UserInputHandler();
        ComputerNumberGenerator gameSession = new ComputerNumberGenerator();
        OutputView outputView = new OutputView();
        ResultGenerator resultGenerator = new ResultGenerator();
        InputValidator inputValidator = new InputValidator();
        gameHandler = new GameHandler(userInputHandler, gameSession, outputView, resultGenerator, inputValidator);
    }

    public void runGame(){
        do{
            gameHandler.initializeGameSession();
        }while(gameHandler.playGameSession());
    }
}
