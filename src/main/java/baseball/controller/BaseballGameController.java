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
        OutputView.printBaseballGameStartMessage();
        do {
            playSingleBaseballGame();
            OutputView.printAnswerMessage();
            OutputView.printRestartOrEndInputMessage();
        } while (isRestart());
    }

    private void playSingleBaseballGame() {
        String randomNumbers = computer.generateRandomNumbers();

        do {
            referee.setUpGame();
            OutputView.printMessageToInputNumbers();

            String inputNumbers = InputView.inputNumbers();
            Validation.validateInputThreeNumber(inputNumbers);

            referee.calculateBallAndStrikeNumber(randomNumbers, inputNumbers);
            determineResult(referee.getStrikeNumber(), referee.getBallNumber());
        } while (!referee.isThreeStrike(referee.getStrikeNumber()));
    }

    private boolean isRestart() {
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
