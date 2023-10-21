package baseball.controller;

import baseball.model.Computer;
import baseball.model.Constants;
import baseball.model.Referee;
import baseball.model.Validation;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private final Computer computer = new Computer();
    private final Referee referee = new Referee();

    public void play() {
        String randomNumbers = computer.generateRandomNumbers();

        do {
            OutputView.printMessageToInputNumbers();

            String inputNumbers = InputView.inputNumbers();

            Validation.validateSameNumber(inputNumbers);
            Validation.validateNumberOfNumbers(inputNumbers);
            Validation.validateThatInputIsNumeric(inputNumbers);

            int strikeNumbers = referee.calculateStrikeNumbers(randomNumbers, inputNumbers);
            int ballNumbers = referee.calculateBallNumbers(randomNumbers, inputNumbers);

            determineResult(strikeNumbers, ballNumbers);

            if (referee.isThreeStrike(strikeNumbers)) {
                OutputView.printAnswerMessage();
                OutputView.printRestartOrEndInputMessage();
                break;
            }
        } while (true);
    }

    public boolean isRestart() {
        String restartOrEndNumber = InputView.inputNumbers();
        Validation.validateRestartOrEnd(restartOrEndNumber);

        return Constants.GAME_RESTART_NUMBER.equals(restartOrEndNumber);
    }

    private void determineResult(int strikeNumbers, int ballNumbers) {
        if (referee.isNothing(strikeNumbers, ballNumbers)) {
            OutputView.printNothing();
        }
        if (referee.isOnlyBall(strikeNumbers, ballNumbers)) {
            OutputView.printOnlyBall(ballNumbers);
        }
        if (referee.isOnlyStrike(strikeNumbers, ballNumbers)) {
            OutputView.printOnlyStrike(strikeNumbers);
        }
        if (referee.isStrikeAndBall(strikeNumbers, ballNumbers)) {
            OutputView.printBallAndStrike(ballNumbers, strikeNumbers);
        }
    }
}
