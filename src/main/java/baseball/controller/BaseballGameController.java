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

            if (isThreeStrike(strikeNumbers)) {
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
        if (isNothing(strikeNumbers, ballNumbers)) {
            OutputView.printNothing();
        }
        if (isOnlyBall(strikeNumbers, ballNumbers)) {
            OutputView.printOnlyBall(ballNumbers);
        }
        if (isOnlyStrike(strikeNumbers, ballNumbers)) {
            OutputView.printOnlyStrike(strikeNumbers);
        }
        if (isStrikeAndBall(strikeNumbers, ballNumbers)) {
            OutputView.printBallAndStrike(ballNumbers, strikeNumbers);
        }
    }

    private boolean isNothing(int strikeNumbers, int ballNumbers) {
        return strikeNumbers == Constants.ZERO && ballNumbers == Constants.ZERO;
    }

    private boolean isOnlyBall(int strikeNumbers, int ballNumbers) {
        return strikeNumbers == Constants.ZERO && ballNumbers != Constants.ZERO;
    }

    private boolean isOnlyStrike(int strikeNumbers, int ballNumbers) {
        return strikeNumbers != Constants.ZERO && ballNumbers == Constants.ZERO;
    }

    private boolean isStrikeAndBall(int strikeNumbers, int ballNumbers) {
        return strikeNumbers != Constants.ZERO && ballNumbers != Constants.ZERO;
    }

    private boolean isThreeStrike(int strikeNumbers) {
        return strikeNumbers == Constants.THREE_STRIKE;
    }
}
