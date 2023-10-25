package baseball.controller;

import baseball.constants.Constants;
import baseball.model.RandomGenerator;
import baseball.model.StrikeAndBallCounter;
import baseball.validator.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BasketballGameController {

    public void playGame() {
        OutputView.startGame();
        while (true) {
            playBasketBallGame();
            OutputView.finishGame();

            String restartOrQuit = InputView.getRestartOrQuit();
            Validator validator = new Validator();
            validator.validateRestartOrQuit(restartOrQuit);
            if (Integer.parseInt(restartOrQuit) == Constants.QUIT) {
                break;
            }
        }
    }

    public void playBasketBallGame() {
        RandomGenerator randomGenerator = new RandomGenerator();
        List<Integer> computerNumber = randomGenerator.createRandomNumber();

        while (true) {
            String userInputNumber = InputView.getInputNumber();
            Validator validator = new Validator();
            validator.validateUserInputNumber(userInputNumber);

            StrikeAndBallCounter strikeAndBallCounter = new StrikeAndBallCounter();
            int[] strikeAndBallCount = strikeAndBallCounter.getStrikeAndBallCount(computerNumber,
                userInputNumber);
            OutputView.showGameResult(strikeAndBallCount);
            if (strikeAndBallCount[Constants.STRIKE_INDEX] == Constants.NUMBER_SIZE) {
                break;
            }
        }
    }
}
