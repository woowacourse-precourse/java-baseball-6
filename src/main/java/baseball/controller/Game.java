package baseball.controller;

import baseball.domain.Number;
import baseball.domain.Result;
import baseball.validator.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

import static baseball.view.OutputView.printStaticNotice;
import static baseball.view.constants.StaticNotice.GAME_START;

public class Game {
    public void start() {
        printStaticNotice(GAME_START);
        do {
            Number computerNumber = Number.generateRandomNumbers();
            play(computerNumber);
        } while (!askRestartOrExit());
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

    private boolean askRestartOrExit() {
        String input = InputView.askRestartOrExit();
        return InputValidator.isValidRestartFlag(input);
    }
}
