package baseball.controller;

import baseball.model.BaseballNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private static final OutputView output = new OutputView();
    private static final InputView input = new InputView();
    private BaseballNumbers computer;
    private final int IS_CORRECT = 3;
    private final String GAME_RESET = "1";
    private final String GAME_TERMINATE = "2";
    private final String ONE_OR_TWO_EXCEPTION = "1 또는 2를 입력해 주세요.";
    private int ball;
    private int strike;

    public void game() {
        output.startMessage();
        do {
            reset();
            start();
        } while (gameReset());
    }

    private boolean gameReset() {
        String s = input.resetOrEnd();
        return isOneOrTwo(s);
    }

    private boolean isOneOrTwo(String s) {
        if (s.equals(GAME_RESET)) {
            return true;
        }
        if (s.equals(GAME_TERMINATE)) {
            return false;
        }
        throw new IllegalArgumentException(ONE_OR_TWO_EXCEPTION);
    }

    private void reset() {
        ball = 0;
        strike = 0;
        computer = BaseballNumbers.computerNumbers();
    }

    public void start() {
        BaseballNumbers player;
        while (true) {
            player = BaseballNumbers.playerNumbers(input.inputNumber());
            if (!isCorrect(player)) {
                continue;
            }
            output.gameSuccessMessage();
            break;
        }
    }

    public boolean isCorrect(BaseballNumbers other) {
        ball = computer.countBall(other);
        strike = computer.countStrike(other);

        output.printResult(ball, strike, ball == 0 && strike == 0);

        if (strike == IS_CORRECT) {
            return true;
        }
        return false;
    }
}
