package baseball.model.number;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Constant.PLAY_NUMBER_DIGIT;

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
            throw new IllegalArgumentException("1 ~ 9 사이의 값이어야만 합니다.");
        }
    }

    private void validateDigitLength(final String number) {
        if (number.length() != PLAY_NUMBER_DIGIT.getValue()) {
            throw new IllegalArgumentException("길이는 3이어야 합니다.");
        }
    }

    private void validateEachUnique(final String number) {
        List<String> splitNumbers = List.of(number.split(""));
        Set<String> numberSet = new HashSet<>(splitNumbers);
        if (numberSet.size() != splitNumbers.size()) {
            throw new IllegalArgumentException("숫자들이 중복되면 안 됩니다.");
        }
    }

    public String getNumber() {
        return String.valueOf(number);
    }
}
