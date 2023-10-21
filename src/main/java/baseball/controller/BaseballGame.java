package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameResult;
import baseball.model.User;
import baseball.validator.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGame {
    private List<Integer> computerNumber;
    private User user;

    public void startGame() {
        GameResult gameResult;
        OutputView.printGameStartMessage();
        createComputerNumber();
        do {
            getUserNumber();
            gameResult = compareNumber();
        } while(!gameResult.isSuccess());
        OutputView.printThreeStrikeMessage();
        getRestartOrExit();
    }

    private void createComputerNumber() {
        Computer computer = new Computer();
        computerNumber = computer.getComputerNumber();
    }

    private void getUserNumber() {
        String userNumber = InputView.getUserNumber();
        user = new User(userNumber);
    }

    private GameResult compareNumber() {
        List<Integer> userNumber = user.getUserNumber();
        int strike = countStrike(userNumber);
        int ball = countBall(userNumber);

        OutputView.printOneGameResult(strike, ball);

        return new GameResult(strike, ball);
    }

    private int countStrike(List<Integer> userNumber) {
        int strike = 0;

        for(int num : userNumber) {
            if(userNumber.indexOf(num) == computerNumber.indexOf(num)) {
                strike++;
            }
        }

        return strike;
    }

    private int countBall(List<Integer> userNumber) {
        int ball = 0;

        for(int num : userNumber) {
            if(userNumber.indexOf(num) != computerNumber.indexOf(num) && computerNumber.contains(num)) {
                ball++;
            }
        }

        return ball;
    }

    private boolean getRestartOrExit() {
        String restartOrExit = InputView.getRestartOrExit();
        Validator.validateRestartOrExit(restartOrExit);

        if(restartOrExit.equals("1")) {
            return true;
        }

        return false;
    }
}
