package baseball;

import static baseball.domain.ErrorCode.NOT_NUMBER_STRING;
import static baseball.view.InputView.getEndOption;
import static baseball.view.InputView.getNumbers;
import static baseball.view.OutputView.printEnd;
import static baseball.view.OutputView.printHint;
import static baseball.view.OutputView.printStart;

import baseball.domain.Board;
import baseball.domain.Game;
import baseball.exception.InvalidArgumentException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {

    private final Game game;

    public BaseballGame() {
        game = new Game();
    }

    public void start() {
        printStart();
        do {
            game.init();
            run();
        } while (!game.isEnd(getOption()));
    }

    private void run() {
        do {
            Board board = game.run(getBallNumbers());
            printHint(board);
        } while (!game.isMatch());
        printEnd();
    }

    private int getOption() {
        String option = getEndOption();
        return parseInt(option);
    }

    private List<Integer> getBallNumbers() {
        String[] numbers = getNumbers().split("");
        return Arrays.stream(numbers)
            .map(this::parseInt)
            .collect(Collectors.toList());
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException(NOT_NUMBER_STRING);
        }
    }
}
