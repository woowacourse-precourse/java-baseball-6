package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGame {
    private Computer computer;
    private User user;

    public void startGame() {
        OutputView.printGameStartMessage();
        createComputerNumber();
        getUserNumber();
        compareNumbers();
    }

    private void createComputerNumber() {
        computer = new Computer();
    }

    private void getUserNumber() {
        String userNumber = InputView.getUserNumber();
        user = new User(userNumber);
    }

    private void compareNumbers() {
        List<Integer> computerNumber = computer.getComputerNumber();
        List<Integer> userNumber = user.getUserNumber();
        int strike = 0;
        int ball = 0;

        for(int num : userNumber) {
            if(userNumber.indexOf(num) == computerNumber.indexOf(num)) {
                strike++;
            }
            if(userNumber.indexOf(num) != computerNumber.indexOf(num) && computerNumber.contains(num)) {
                ball++;
            }
        }

        OutputView.printOneGameResult(strike, ball);
    }
}
