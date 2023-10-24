package baseball.domain;

import baseball.ui.InputView;
import baseball.ui.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final InputView inputView;
    private final OutputView outputView;

    private static Computer computer;
    private int strike;
    private int ball;

    public BaseballGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        strike = 0;
        ball = 0;
    }

    public void start() {
        outputView.printGameStart();
        play();
    }

    public void play() {
        List<Integer> playerNumbers = inputView.readPlayerNumbers();

        computer = Computer.generate();

        for (int i = 0; i < 3; i++) {
            int playerNumber = playerNumbers.get(i);
            int computerNumber = computer.getNumberOf(i);

            if (playerNumber == computerNumber) {
                ++strike;
            } else if (computer.containOf(playerNumber)) {
                ++ball;
            }
        }

        judgeResult();
        proceed();
    }

    private void judgeResult() {
        if (strike == 3) {
            outputView.printGameFinish();
        } else {
            outputView.printGameResult(strike, ball);
        }
    }

    private void proceed() {
        if (strike == 3) {
            String option = inputView.readRestart();
            if (option.equals("1")) {
                computer = Computer.generate();
                play();
            } else if (option.equals("2")) {
                return;
            }
        } else {
            outputView.printGameResult(ball, strike);
            play();
        }
    }
}
