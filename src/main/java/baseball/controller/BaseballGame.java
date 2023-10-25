package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameResult;
import baseball.model.User;
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

        Computer computer = new Computer();
        User user;
        GameResult gameResult;

        do {
            user = new User(InputView.getUserNumber());
            gameResult = computer.compareNumbers(user);
            OutputView.printOneGameResult(gameResult.getStrike(), gameResult.getBall());
        } while (!gameResult.isSuccess());

        OutputView.printThreeStrikeMessage();
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
