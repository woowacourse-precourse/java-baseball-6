package baseball;

import static baseball.Constant.INVALID_BLANK_VALUE_MESSAGE;
import static baseball.Constant.INVALID_DUPLICATE_MESSAGE;
import static baseball.Constant.INVALID_FORMAT_MESSAGE;
import static baseball.Constant.INVALID_LENGTH_MESSAGE;
import static baseball.Constant.MAX_NUMBER_LENGTH;
import static baseball.Constant.NUMERIC_PATTERN;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private String playerNumbers;

    public Player(String playerNumbers) {
        validateNumbers(playerNumbers);
        this.playerNumbers = playerNumbers;
    }

    public String getPlayerNumbers() {
        return playerNumbers;
    }

    private void validateNumbers(String numbers) {
        if (isBlank(numbers)) {
            throw new IllegalArgumentException(INVALID_BLANK_VALUE_MESSAGE);
        }
        if (!isValidNumeric(numbers)) {
            throw new IllegalArgumentException(INVALID_FORMAT_MESSAGE);
        }
        if (!isValidLength(numbers)) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }
        if (!isUnique(numbers)) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_MESSAGE);
        }
    }

    private boolean isValidNumeric(String numbers) {
        return numbers.matches(NUMERIC_PATTERN);
    }

    private boolean isValidLength(String numbers) {
        return numbers.length() == MAX_NUMBER_LENGTH;
    }

    private boolean isUnique(String numbers) {
        Set<Character> uniqueDigits = new HashSet<Character>();
        for (char element : numbers.toCharArray()) {
            uniqueDigits.add(element);
        }
        return uniqueDigits.size() == MAX_NUMBER_LENGTH;
    }

    private boolean isBlank(String numbers) {
        return numbers.length() == 0;
    }
}
