package baseball.game;

import baseball.generator.ComputerNumberGenerator;
import baseball.generator.ResultGenerator;
import baseball.input.GuessInputProcessor;
import baseball.input.converter.InputConverter;
import baseball.input.ChoiceInputProcessor;
import baseball.input.validator.UserChoiceValidator;
import baseball.input.validator.UserGuessValidator;
import baseball.view.OutputView;

public class BaseballGame {
    private final GameController gameController;

    public BaseballGame () {
        InputConverter inputConverter = new InputConverter();
        UserGuessValidator userGuessValidator= new UserGuessValidator();
        UserChoiceValidator userChoiceValidator = new UserChoiceValidator();

        gameController  = new GameController.Builder()
                .withGuessInputProcessor(new GuessInputProcessor(inputConverter, userGuessValidator))
                .withChoiceInputProcessor(new ChoiceInputProcessor(inputConverter, userChoiceValidator))
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
