package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameResult;
import baseball.model.Numbers;
import baseball.model.User;
import baseball.validator.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGame {
    private static final String RESTART = "1";
    private Numbers computerNumber;

    public void startGame() {
        do {
            playOneGame();
        } while(restart());
    }

    private void playOneGame() {
        GameResult gameResult;
        OutputView.printGameStartMessage();
        createComputerNumber();

        do {
            String userNumber = InputView.getUserNumber();
            User user = new User(userNumber);
            gameResult = computerNumber.compareNumbers(user.getUserNumber());
            OutputView.printOneGameResult(gameResult.getStrike(), gameResult.getBall());
        } while (!gameResult.isSuccess());

        OutputView.printThreeStrikeMessage();
    }

    private void createComputerNumber() {
        Computer computer = new Computer();
        computerNumber = computer.getComputerNumber();
    }

    private boolean restart() {
        String restartOrExit = InputView.getRestartOrExit();
        Validator.validateRestartOrExit(restartOrExit);

        if(restartOrExit.equals(RESTART)) {
            return true;
        }

        return false;
    }
}
