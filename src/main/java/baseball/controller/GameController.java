package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.NumberBaseball;
import baseball.domain.ResultChecker;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private static final int BALL_COUNT = 3;
    private Computer computer;

    public GameController() {
        resetComputer();
    }

    private void resetComputer() {
        this.computer = new Computer(BALL_COUNT);
    }

    public void playGame() {
        OutputView.printGameStart();

        while (true) {
            List<Integer> userNumbers = InputView.inputNumbers();
            validateInput(userNumbers);
            ResultChecker resultChecker = new ResultChecker(computer.getNumberBaseball(),
                    new NumberBaseball(userNumbers));
            OutputView.printResult(resultChecker.getStrike(), resultChecker.getBall());

            if (resultChecker.isAllStrikes(BALL_COUNT)) {
                postGame();
                return;
            }
        }
    }

    private void validateInput(List<Integer> numbers) {
        if (numbers.size() != BALL_COUNT) {
            throw new IllegalArgumentException(
                    String.format("%d개의 숫자를 입력해야 합니다.", BALL_COUNT)
            );
        }
    }

    private void postGame() {
        OutputView.printGameEnd();
        int choice = InputView.inputRestartOrExit();
        if (choice == 1) {
            resetComputer();
            playGame();
        }
    }
}
