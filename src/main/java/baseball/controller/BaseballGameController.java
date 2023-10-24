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
            determineResult();
        } while (!referee.isThreeStrike());
    }

    private boolean isRestart() {
        String restartOrEndNumber = InputView.inputNumbers();
        Validation.validateRestartOrEnd(restartOrEndNumber);

        return Constants.GAME_RESTART_NUMBER.equals(restartOrEndNumber);
    }

    private void determineResult() {
        if (referee.isNothing()) {
            OutputView.printNothing();
        }
        if (referee.isOnlyBall()) {
            OutputView.printOnlyBall(referee.getBallNumber());
        }
        if (referee.isOnlyStrike()) {
            OutputView.printOnlyStrike(referee.getStrikeNumber());
        }
        if (referee.isStrikeAndBall()) {
            OutputView.printBallAndStrike(referee.getBallNumber(), referee.getStrikeNumber());
        }
    }
}
