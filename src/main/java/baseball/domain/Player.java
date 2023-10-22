package baseball.domain;

import baseball.util.BallNumbersValidator;
import java.util.List;

public class Player {
    private final List<Integer> numbers;

    private Player(List<Integer> numbers) {
        BallNumbersValidator.validateInputSize(numbers);
        BallNumbersValidator.validateInputRange(numbers);
        BallNumbersValidator.validateInputUniqueness(numbers);
        this.numbers = numbers;
    }

    public static Player of(List<Integer> numbers) {
        return new Player(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
