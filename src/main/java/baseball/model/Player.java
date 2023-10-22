package baseball.model;

import baseball.utils.ErrorMessages;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Player {
    private static final int NUMBER_SIZE = 3;

    private final List<Integer> numbers;


    public Player(String input) {
        validate(input);
        this.numbers = toNumbers(input);
    }

    private void validate(String input) {
        validateInteger(input);
        validateSize(input);
        validateDuplicate(input);
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.PLAYER_NUMBERS_NOT_INTEGER);
        }
    }

    private void validateSize(String input) {
        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.PLAYER_NUMBERS_INVALID_SIZE);
        }
    }

    private void validateDuplicate(String input) {
        HashSet<String> set = new HashSet<>(List.of(input.split("")));
        if (set.size() != input.length()) {
            throw new IllegalArgumentException(ErrorMessages.PLAYER_NUMBERS_DUPLICATE);
        }
    }

    private List<Integer> toNumbers(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    public Integer getNumber(int idx) {
        return this.numbers.get(idx);
    }
}
