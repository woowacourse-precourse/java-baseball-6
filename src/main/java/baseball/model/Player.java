package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static baseball.message.ErrorMessages.INVALID_DUPLICATE;
import static baseball.message.ErrorMessages.INVALID_INPUT;
import static baseball.message.ErrorMessages.INVALID_LENGTH;
import static baseball.message.ErrorMessages.INVALID_RANGE;

public class Player {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_OF_DIGITS = 3;

    private final List<Integer> numbers;

    public Player() {
        this.numbers = new ArrayList<>(NUMBER_OF_DIGITS);
    }

    public void inputNumbers(String input) {
        validateInputIsNumber(input);

        this.numbers.clear();
        for (String number : input.split("")) {
            this.numbers.add(Integer.parseInt(number));
        }

        validateNumbers();
    }

    private void validateInputIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    public void validateNumbers() {
        if (this.numbers.size() != NUMBER_OF_DIGITS) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }

        if (this.numbers.get(0) < MIN_NUMBER || this.numbers.get(0) > MAX_NUMBER
                || this.numbers.get(1) < MIN_NUMBER || this.numbers.get(1) > MAX_NUMBER
                || this.numbers.get(2) < MIN_NUMBER || this.numbers.get(2) > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }

        if (this.numbers.get(0).equals(this.numbers.get(1))
                || this.numbers.get(0).equals(this.numbers.get(2))
                || this.numbers.get(1).equals(this.numbers.get(2))) {
            throw new IllegalArgumentException(INVALID_DUPLICATE);
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
