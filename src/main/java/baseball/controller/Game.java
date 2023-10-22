package baseball.controller;

import baseball.domain.Numbers;
import baseball.domain.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Objects;

import static baseball.config.GameConfig.GAME_RESTART_FLAG;

public class Game {
    private Numbers computerNumber;
    private Numbers playerNumber;
    private Result result;

    public void start() {
        OutputView.printGameStart();
        do {
            computerNumber = Numbers.generateRandomNumbers();
            play();
        } while (!isRestart());
    }

    private void play() {
        do {
            playerNumber = Numbers.inputPlayerNumbers();
            result = Result.create(playerNumber, computerNumber);
            result.print();
        } while (!result.checkGameOver());
    }

    private static boolean isRestart() {
        return Objects.equals(InputView.requestRestartOrExit(), GAME_RESTART_FLAG.getValue());
    }
}
