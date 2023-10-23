package baseball.model;

import static baseball.Constant.PLAY_NUMBER_DIGIT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayNumber {

    private final int number;

    private PlayNumber(final String number) {
        validateNumber(number);
        this.number = Integer.parseInt(number);
    }

    public static PlayNumber from(final String number) {
        return new PlayNumber(number);
    }

    private void validateNumber(final String number) {
        validateNumberValue(number);
        validateDigitLength(number);
        validateEachUnique(number);
    }

    private void validateNumberValue(final String number) {
        if (!number.matches("^[1-9]+$")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDigitLength(final String number) {
        if (number.length() != PLAY_NUMBER_DIGIT.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateEachUnique(final String number) {
        List<String> splitNumbers = List.of(number.split(""));
        Set<String> numberSet = new HashSet<>(splitNumbers);
        if (numberSet.size() != splitNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public String getNumber() {
        return String.valueOf(number);
    }
}
