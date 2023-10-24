package baseball;

import java.util.Collections;
import java.util.List;

public class GuessedNumbers {

    private final List<Integer> numbers;

    public GuessedNumbers(List<Integer> numbers, BaseballGameRules gameRules) {
        gameRules.validateNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
