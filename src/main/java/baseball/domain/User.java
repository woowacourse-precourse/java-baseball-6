package baseball.domain;

import static baseball.utils.Utility.convertStringToBall;

import baseball.ui.IInput;
import java.util.List;

public class User implements IPlayer {

    private final IInput input;
    private final int NUMBER_BALLS;
    private List<Integer> numbers;

    public User(IInput input, final int NUMBER_BALLS) {
        this.input = input;
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
        String input = this.input.scan();

        return convertStringToBall(input, NUMBER_BALLS);
    }

    public Command selectCommand() {
        String inputCommand = input.scan();

        return Command.findCommand(inputCommand);
    }
}
