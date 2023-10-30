package baseball.validator;

import baseball.view.InputView;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static final String WRONG_INPUT_NUMBERS_LENGTH_MESSAGE = "3자리 숫자만 입력 가능합니다.";
    public static final String WRONG_INPUT_CHARACTER_MESSAGE = "숫자만 입력 가능합니다.";
    public static final String WRONG_INPUT_START_NEW_GAME_OR_EXIT_MESSAGE = "게임 재시작 여부는 숫자 1, 2만 입력 가능합니다.";
    public static final String WRONG_INPUT_DUPLICATION_NUMBERS_MESSAGE = "중복되지 않는 3자리 숫자만 입력가능합니다.";

    public static void validateInputLength(final String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(WRONG_INPUT_NUMBERS_LENGTH_MESSAGE);
        }
    }

    public static void validateInputNumber(final String input) {
        long count = Arrays.stream(input.split("")).filter(i -> i.charAt(0) < '1' || i.charAt(0) > '9').count();

        if (count > 0) {
            throw new IllegalArgumentException(WRONG_INPUT_CHARACTER_MESSAGE);
        }
    }

    public static void validateInputStartNewGame(final String inputStartNewGame) {
        if (!InputView.START_NEW_GAME_NUMBER.equals(inputStartNewGame) && !InputView.END_GAME_NUMBER.equals(
                inputStartNewGame)) {
            throw new IllegalArgumentException(WRONG_INPUT_START_NEW_GAME_OR_EXIT_MESSAGE);
        }
    }

    public static void validateNumberDuplication(final List<Integer> inputNumbers) {
        Set<Integer> inputSet = new HashSet<>(inputNumbers);

        if (inputSet.size() != 3) {
            throw new IllegalArgumentException(WRONG_INPUT_DUPLICATION_NUMBERS_MESSAGE);
        }
    }
}
