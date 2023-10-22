package baseball.controller;

import baseball.domain.Number;
import baseball.domain.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Objects;

import static baseball.config.GameConfig.GAME_RESTART_FLAG;

public class Game {
    private Number computerNumber;
    private Number playerNumber;
    private Result result;

    public void start() {
        OutputView.printGameStart();
        do {
            computerNumber = Number.generateRandomNumber();
            play();
        } while (!isRestart());
    }

    private void play() {
        do {
            playerNumber = Number.inputPlayerNumber();
            result = Result.create(playerNumber, computerNumber);
            result.print();
        } while (!result.checkGameOver());
    }

    private static boolean isRestart() {
        return Objects.equals(InputView.requestRestartOrExit(), GAME_RESTART_FLAG.getValue());
    }
}
