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
        UserChoiceValidator userChoiceValidator = new UserChoiceValidator();

        GuessInputProcessor guessInputProcessor = new GuessInputProcessor(inputConverter, new UserGuessValidator());
        ChoiceInputProcessor choiceInputProcessor = new ChoiceInputProcessor(inputConverter, new UserChoiceValidator());
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        OutputView outputView = new OutputView();
        ResultGenerator resultGenerator = new ResultGenerator();

        gameController = new GameController(choiceInputProcessor, guessInputProcessor, computerNumberGenerator, outputView, resultGenerator);
    }

    public void runGame(){
        do{
            gameController.initializeGameSession();
        }while(gameController.playGameSession());
    }
}
