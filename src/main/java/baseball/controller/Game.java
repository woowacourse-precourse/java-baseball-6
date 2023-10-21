package baseball.controller;

import static baseball.config.GameConfig.GAME_RESTART_FLAG;

import baseball.model.Number;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Objects;

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
