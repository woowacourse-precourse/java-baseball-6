package baseball.domain;

import static baseball.utils.ErrorMessages.PLAYER_NUMBERS_DUPLICATE;
import static baseball.utils.ErrorMessages.PLAYER_NUMBERS_INVALID_SIZE;
import static baseball.utils.ErrorMessages.PLAYER_NUMBERS_ZERO_CONTAIN;

import java.util.Arrays;
import java.util.List;

public class Player {
    public static final int NUMBER_SIZE = 3;
    public static final String DELIMITER = "";
    private final List<Integer> numbers;

    public Player(String input) {
        validateSize(input);
        validateDuplicate(input);
        validateZeroContain(input);
        this.numbers = convert(input);
    }

    private void validateSize(String input) {
        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(PLAYER_NUMBERS_INVALID_SIZE);
        }
    }

    private void validateDuplicate(String input) {
        long uniqueCount = Arrays.stream(input.split(DELIMITER))
                .distinct()
                .count();

        if (uniqueCount != NUMBER_SIZE) {
            throw new IllegalArgumentException(PLAYER_NUMBERS_DUPLICATE);
        }
    }

    private void validateZeroContain(String input) {
        String replace = input.replace("0", "");

        if (replace.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(PLAYER_NUMBERS_ZERO_CONTAIN);
        }
    }

    private List<Integer> convert(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public Boolean isSameIndex(int number, int index) {
        return numbers.indexOf(number) == index;
    }

    public Boolean isContain(int number) {
        return numbers.contains(number);
    }
}
