package baseball.domain;

import baseball.exception.ErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PlayerNumbers {

    private final List<Integer> playerNumbers;

    private PlayerNumbers(final String inputString) {
        validate(inputString);
        this.playerNumbers = stringToIntegerArray(inputString);
    }

    public static PlayerNumbers of(final String inputString) {
        return new PlayerNumbers(inputString);
    }

    private List<Integer> stringToIntegerArray(final String inputPlayerNumbers) {
        return Arrays.stream(inputPlayerNumbers.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    private void validate(final String inputPlayerNumbers) {
        validateFormat(inputPlayerNumbers);
        validateDuplication(inputPlayerNumbers);
    }

    private void validateDuplication(final String inputPlayerNumbers) {
        List<Integer> numbers = stringToIntegerArray(inputPlayerNumbers);
        HashSet<Integer> removeDuplicated = new HashSet<>(numbers);

        if (removeDuplicated.size() != AnswerNumbers.SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    private void validateFormat(final String inputPlayerNumbers) {
        if (!inputPlayerNumbers.matches("^[123456789]{3}$")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    public int getNumberByPosition(int position) {
        return playerNumbers.get(position);
    }
}
