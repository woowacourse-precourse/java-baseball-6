package baseball.domain;

import static baseball.utils.Utility.convertStringToIntegerList;

import baseball.ui.ConsoleInput;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public Response respondsTo(IPlayer opponentUser) {
        int strikeCount = 0;
        int ballCount = 0;
        int index = 0;

        for (int ball : numbers) {
            if (opponentUser.checkIfIsStrike(ball, index++)) {
                ++strikeCount;
            } else if (opponentUser.checkIfIsBall(ball)) {
                ++ballCount;
            }
        }

        return new Response(new ArrayList<>(Arrays.asList(strikeCount, ballCount)), NUMBER_BALLS);
    }

    @Override
    public boolean checkIfIsStrike(int ball, int index) {
        return numbers.get(index) == ball;
    }

    @Override
    public boolean checkIfIsBall(int ball) {
        return numbers.contains(ball);
    }

    @Override
    public int countNumberBalls() {
        return numbers.size();
    }

    private List<Integer> generateInputNumber(int NUMBER_BALLS) {
        String input = CONSOLE_INPUT.scanGameNumber(NUMBER_BALLS);

        return convertStringToIntegerList(input);
    }
}
