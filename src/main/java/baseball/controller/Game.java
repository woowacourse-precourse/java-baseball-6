package baseball.controller;

import baseball.domain.Number;
import baseball.domain.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Objects;

import static baseball.config.GlobalConfig.GAME_RESTART_FLAG;
import static baseball.view.constants.PrintMessage.GAME_START;

public class Game {
    public void start() {
        OutputView.printInformation(GAME_START);
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
