package baseball.service;

import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {

    private static final int SUCCESS_CONDITION = 3;
    private static final int NOTHING_CONDITION = 0;
    private static final int RESTART_NUMBER = 1;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private Computer computer;
    private Balls userBalls;

    public void createComputerBalls() {
        computer = new Computer();
        computer.createRandomBalls();
    }

    public void inputUserBalls() {
        userBalls = new Balls();
        String balls = inputView.inputNumber();
        userBalls.convertToBalls(balls);
    }

    public int countContainedBalls() {
        return computer.countContainedBalls(userBalls);
    }

    public int countStrike() {
        return computer.countContainedBallsAsIndex(userBalls);
    }

    public boolean isThreeStrike(int strike) {
        if (strike == SUCCESS_CONDITION) {
            outputView.outputStrikeResult(SUCCESS_CONDITION);
            return true;
        }
        return false;
    }

    public boolean isNothing(int ball) {
        if (ball == NOTHING_CONDITION) {
            outputView.outputNothing();
            return true;
        }
        return false;
    }

    public void outputResult(int ball, int strike) {
        if (ball == 0) {
            outputView.outputStrikeResult(strike);
            return;
        }
        if (strike == 0) {
            outputView.outputBallResult(ball);
            return;
        }
        outputView.outputBallAndStrikeResult(ball, strike);
    }

    public void outputGameSuccess() {
        outputView.outputGameSuccess();
    }

    public void outputRestartGame() {
        outputView.outputRestartGame();
    }

    public void outputGameStart() {
        outputView.outputGameStart();
    }

    public boolean inputRestartNumber() {
        return Integer.parseInt(inputView.inputRestartNum()) == RESTART_NUMBER;
    }
}
