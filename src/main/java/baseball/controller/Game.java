package baseball.controller;

import static baseball.config.Config.NUMBER_LENGTH;

import baseball.model.ComputerNumber;
import baseball.model.Hint;
import baseball.model.PlayerNumber;
import baseball.view.InputView;
import java.util.Objects;

public class Game {


    public void start() {
        String computerNumber, playerNumber;

        PlayerNumber player = new PlayerNumber();
        ComputerNumber computer = new ComputerNumber();
        Hint hint = new Hint();

        do {
            computerNumber = computer.pickRandomNumber(NUMBER_LENGTH);
            do {
                playerNumber = player.inputNumber(NUMBER_LENGTH);

                hint.reset();
                hint.updateHint(playerNumber, computerNumber);
                hint.printHint();
            } while (!hint.checkClear());
        } while (Objects.equals(InputView.requestRestartOrExit(), "1"));

    }
}
