package baseball.controller;

import baseball.domain.Number;
import baseball.domain.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Objects;

import static baseball.config.GlobalConfig.GAME_RESTART_FLAG;

public class Game {
    public void start() {
        OutputView.printInitialGameStart();
        do {
            play(Number.generateRandomNumbers());
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
        return Objects.equals(InputView.askRestartOrExit(), GAME_RESTART_FLAG.toString());
    }
}
