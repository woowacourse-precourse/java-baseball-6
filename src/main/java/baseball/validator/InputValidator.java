package baseball.validator;

import baseball.util.Constants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static void validateInputLength(final String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_NUMBERS_LENGTH_MESSAGE);
        }
    }

    public static void validateInputNumber(final String input) {
        long count = Arrays.stream(input.split(""))
                .filter(i -> i.charAt(0) < '1' || i.charAt(0) > '9')
                .count();

        if (count > 0) {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_CHARACTER_MESSAGE);
        }
    }

    public static void validateInputStartNewGame(final String inputStartNewGame) {
        if (!Constants.START_NEW_GAME_NUMBER.equals(inputStartNewGame) && !Constants.END_GAME_NUMBER.equals(
                inputStartNewGame)) {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_START_NEW_GAME_OR_EXIT_MESSAGE);
        }
    }

    public static void validateNumberDuplication(final List<Integer> inputNumbers) {
        Set<Integer> inputSet = new HashSet<>(inputNumbers);

        if (inputSet.size() != 3) {
            throw new IllegalArgumentException(Constants.WRONG_INPUT_DUPLICATION_NUMBERS_MESSAGE);
        }
    }
}
