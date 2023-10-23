package baseball.domain;

import baseball.utils.ErrorMessages;
import baseball.utils.IntegerConvertor;
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
        validateSize(input);
        validateDuplicate(input);
        validateZeroContain(input);
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

    private void validateZeroContain(String input) {
        String replace = input.replace("0", "");
        if (replace.length() != input.length()) {
            throw new IllegalArgumentException(ErrorMessages.PLAYER_NUMBERS_ZERO_CONTAIN);
        }
    }

    private List<Integer> toNumbers(String input) {
        return Arrays.stream(input.split(""))
                .map(IntegerConvertor::toInteger)
                .toList();
    }

    public int getNumber(int idx) {
        if (idx >= NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.INDEX_OUT_OF_RANGE);
        }
        return this.numbers.get(idx);
    }
}
