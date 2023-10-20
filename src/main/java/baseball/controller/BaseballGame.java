package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private Computer computer;
    private User user;

    public void startGame() {
        OutputView.printGameStartMessage();
        createComputerNumber();
        getUserNumber();
    }

    private void createComputerNumber() {
        computer = new Computer();
    }

    private void getUserNumber() {
        String userNumber = InputView.getUserNumber();

        user = new User(userNumber);
    }
}
