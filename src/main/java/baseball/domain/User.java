package baseball.domain;

import static baseball.utils.Utility.convertStringToIntegerList;

import baseball.ui.ConsoleInput;
import java.util.List;

public class User implements IPlayer {

    private final ConsoleInput CONSOLE_INPUT;
    private final int NUMBER_BALLS;
    private List<Integer> numbers;

    public User(ConsoleInput consoleInput, final int NUMBER_BALLS) {
        CONSOLE_INPUT = consoleInput;
        this.NUMBER_BALLS = NUMBER_BALLS;
    }

    @Override
    public void generatePlayerNumber(final int NUMBER_BALLS) {
        this.numbers = generateInputNumber(NUMBER_BALLS);
    }

    public boolean checkIfIsStrike(int ball, int index) {
        return numbers.get(index) == ball;
    }

    public boolean checkIfIsBall(int ball) {
        return numbers.contains(ball);
    }

    public int countNumberBalls() {
        return numbers.size();
    }

    private List<Integer> generateInputNumber(int NUMBER_BALLS) {
        String input = CONSOLE_INPUT.scanGameNumber(NUMBER_BALLS);

        return convertStringToIntegerList(input);
    }
}
