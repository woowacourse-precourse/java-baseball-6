package baseball.validate;

import java.util.Set;
import java.util.stream.Collectors;

public class CheckInput {
    private static final int INPUT_LENGTH = 3;
    private static final String LENGTH_EXCEPTION_MESSAGE = "입력한 숫자는 3자리여야 합니다.";
    private static final String NON_NUMERIC_EXCEPTION_MESSAGE = "입력한 값은 숫자여야 합니다.";
    private static final String RANGE_EXCEPTION_MESSAGE = "입력한 각각의 숫자는 1~9의 범위여야 합니다.";
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "중복된 값은 입력할 수 없습니다.";

    public static void validatePlayerInput(String userInput) {
        checkLength(userInput);
        checkInteger(userInput);
        checkHasZero(userInput);
        checkDuplicate(userInput);
    }

    private static void checkLength(String userInput) {
        if (userInput.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private static void checkInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (IllegalArgumentException error) {
            throw new IllegalArgumentException(NON_NUMERIC_EXCEPTION_MESSAGE);
        }
    }

    private static void checkHasZero(String userInput) {
        if (userInput.contains("0")) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }
    }

    private static void checkDuplicate(String userInput) {
        Set<Character> characterSet = userInput.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet());
        if (characterSet.size() != INPUT_LENGTH) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }
}
