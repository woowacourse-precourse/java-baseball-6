package baseball.controller;

import baseball.domain.Number;
import baseball.domain.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Objects;

import static baseball.global.GameConfig.GAME_RESTART_FLAG;
import static baseball.view.constants.StaticNotice.GAME_START;

public class Game {
    public void start() {
        OutputView.printStaticNotice(GAME_START);
        do {
            Number computerNumber = Number.generateRandomNumbers();
            play(computerNumber);
        } while (!isRestart());
    }

    private void play(Number computerNumber) {
        while (true) {
            Number playerNumber = Number.inputPlayerNumbers();
            Result result = Result.create(playerNumber, computerNumber);
            OutputView.printMessage(result.createResultMessage());
            if (result.checkGameOver()) {
                break;
            }
        }
    }

    private static boolean isRestart() {
        return Objects.equals(InputView.askRestartOrExit(), GAME_RESTART_FLAG.toString());
    }
}
