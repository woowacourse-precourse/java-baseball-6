package baseball.game;

import baseball.generator.ComputerNumberGenerator;
import baseball.generator.ResultGenerator;
import baseball.input.InputConverter;
import baseball.input.InputProcessor;
import baseball.input.InputValidator;
import baseball.view.OutputView;

public class BaseballGame {
    private final GameController gameController;

    public BaseballGame () {
        InputConverter inputConverter = new InputConverter();
        InputValidator inputValidator = new InputValidator();

        InputProcessor inputProcessor = new InputProcessor(inputConverter, inputValidator);
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        OutputView outputView = new OutputView();
        ResultGenerator resultGenerator = new ResultGenerator();

        gameController = new GameController(inputProcessor, computerNumberGenerator, outputView, resultGenerator);
    }

    public void runGame(){
        do{
            gameController.initializeGameSession();
        }while(gameController.playGameSession());
    }
}
