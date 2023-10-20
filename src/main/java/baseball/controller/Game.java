package baseball.controller;

import static baseball.config.Config.NUMBER_LENGTH;

import baseball.model.Hint;
import baseball.model.Number;
import baseball.view.InputView;
import java.util.Objects;

public class Game {

    private Number computerNumber;
    private Number playerNumber;

    public void start() {
        do {
            computerNumber = Number.generateRandomNumber(NUMBER_LENGTH);
            play();
        } while (Objects.equals(InputView.requestRestartOrExit(), "1"));
    }

    private void play() {
        Hint hint = new Hint();
        do {
            playerNumber = Number.inputPlayerNumber();
            hint.updateHint(playerNumber, computerNumber);
            hint.printHint();
        } while (!hint.checkClear());
    }
}
