package baseball.game;

import baseball.generator.ComputerNumberGenerator;
import baseball.generator.ResultGenerator;
import baseball.input.InputProcessor;
import baseball.input.InputConverter;
import baseball.input.InputValidator;
import baseball.view.OutputView;

public class BaseballGame {
    private final GameController gameController;

    public BaseballGame () {
        InputConverter inputConverter = new InputConverter();
        InputValidator inputValidator = new InputValidator();

        gameController  = new GameController.Builder()
                .withGuessInputProcessor(new InputProcessor(inputConverter, inputValidator))
                .withComputerNumberGenerator(new ComputerNumberGenerator())
                .withOutputView(new OutputView())
                .withResultGenerator(new ResultGenerator())
                .build();
    }

    public void runGame(){
        do{
            gameController.initializeGameSession();
        }while(gameController.playGameSession());
    }
}
