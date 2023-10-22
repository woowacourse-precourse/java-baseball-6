package baseball.controller;

import baseball.model.GameResult;
import baseball.model.Numbers;
import baseball.validator.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private static final String RESTART = "1";

    public void startGame() {
        do {
            playOneGame();
        } while (restart());
    }

    private void playOneGame() {
        OutputView.printGameStartMessage();

        Numbers computerNumber = createComputerNumber();
        Numbers userNumber;
        GameResult gameResult;

        do {
            userNumber = inputUserNumber(InputView.getUserNumber());
            gameResult = userNumber.compareNumbers(computerNumber);
            OutputView.printOneGameResult(gameResult.getStrike(), gameResult.getBall());
        } while (!gameResult.isSuccess());

        OutputView.printThreeStrikeMessage();
    }

    private Numbers createComputerNumber() {
        return new Numbers();
    }

    private Numbers inputUserNumber(String input) {
        return new Numbers(input);
    }

    private boolean restart() {
        String restartOrExit = InputView.getRestartOrExit();
        Validator.validateRestartOrExit(restartOrExit);

        if (restartOrExit.equals(RESTART)) {
            return true;
        }

        return false;
    }
}
