package baseball.controller;

import static baseball.config.Config.NUMBER_LENGTH;

import baseball.model.Number;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Objects;

public class Game {
    private static final String GAME_EXIT_FLAG = "1";

    private Number computerNumber;
    private Number playerNumber;
    private Result result;

    public void start() {
        do {
            computerNumber = Number.generateRandomNumber(NUMBER_LENGTH);
            play();
        } while (Objects.equals(InputView.requestRestartOrExit(), GAME_EXIT_FLAG));
    }

    private void play() {
        OutputView.printGameStart();
        do {
            playerNumber = Number.inputPlayerNumber();
            result = Result.create(playerNumber, computerNumber);
            result.print();
        } while (!result.checkGameOver());
    }
}
