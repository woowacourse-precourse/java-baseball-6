package baseball.controller;

import baseball.domain.Number;
import baseball.domain.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Objects;

public class Game {
    private static final int RANDOM_NUMBER_MINIMUM = 1;
    private static final int RANDOM_NUMBER_MAXIMUM = 9;
    private static final int NUMBER_LENGTH = 3;
    private static final String GAME_RESTART_FLAG = "2";

    public void start() {
        OutputView.printInitialGameStart();
        do {
            play(Number.generateRandomNumbers(
                    RANDOM_NUMBER_MINIMUM, RANDOM_NUMBER_MAXIMUM, NUMBER_LENGTH
            ));
        } while (!isRestart());
    }

    private void play(Number computerNumber) {
        while (true) {
            Number playerNumber = Number.inputPlayerNumbers();
            Result result = Result.create(playerNumber, computerNumber);
            result.print();
            if (result.checkGameOver()) {
                break;
            }
        }
    }

    private static boolean isRestart() {
        return Objects.equals(InputView.askRestartOrExit(), GAME_RESTART_FLAG);
    }
}
