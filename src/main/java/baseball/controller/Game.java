package baseball.controller;

import static baseball.config.Config.NUMBER_LENGTH;

import baseball.model.Hint;
import baseball.model.Number;
import baseball.view.InputView;
import java.util.Objects;

public class Game {

    private Number computerNumber;
    private Number playerNumber;
    private Hint hint;

    public void start() {
        do {
            computerNumber = Number.generateRandomNumber(NUMBER_LENGTH);
            play();
        } while (Objects.equals(InputView.requestRestartOrExit(), "1"));
    }

    private void play() {
        do {
            playerNumber = Number.inputPlayerNumber();
            hint.update(playerNumber, computerNumber);
            hint.print();
        } while (!hint.checkClear());
    }
}
