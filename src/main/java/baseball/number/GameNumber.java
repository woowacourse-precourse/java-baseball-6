package baseball.number;

import java.util.HashSet;
import java.util.Set;

public class GameNumber {
    private static final Integer NUMBER_SIZE = 3;
    private static final Integer START_NUMBER = 1;
    private static final Integer END_NUMBER = 9;
    private final String value;

    public GameNumber(String gameNumber) {
        if (!validateGameNumber(gameNumber)) {
            throw new IllegalArgumentException();
        }
        this.value = gameNumber;
    }

    private boolean validateGameNumber(String gameNumber) {
        if (validateGameNumberLength(gameNumber) && validateGameNumberIsNaturalNumber(gameNumber)
                && validateDuplicatedGameNumber(gameNumber)) {
            return true;
        }

        return false;
    }

    private boolean validateGameNumberLength(String gameNumber) {
        if (gameNumber.length() != NUMBER_SIZE) {
            return false;
        }
        return true;
    }

    private boolean validateGameNumberIsNaturalNumber(String gameNumber) {
        try {
            if (Integer.parseInt(gameNumber) < START_NUMBER) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        for (Character number : gameNumber.toCharArray()) {
            if (number < START_NUMBER && number > END_NUMBER) {
                return false;
            }
        }

        return true;
    }

    private boolean validateDuplicatedGameNumber(String gameNumber) {
        Set<Character> numbers = new HashSet<>();
        for (Character number : gameNumber.toCharArray()) {
            numbers.add(number);
        }

        if (numbers.size() != NUMBER_SIZE) {
            return false;
        }

        return true;
    }

    public String getValue() {
        return value;
    }

}
