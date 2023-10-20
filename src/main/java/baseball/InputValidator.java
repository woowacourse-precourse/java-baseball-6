package baseball;


public class InputValidator {

    public static final int INPUT_NUMBER_LENGTH = 3;
    public static final int CONTINUE_OR_EXIT_NUMBER_LENGTH = 1;
    public static final char MIN_NUMBER = '1';
    public static final char MAX_NUMBER = '9';
    public static final String CONTINUE_NUMBER = "1";
    public static final String EXIT_NUMBER = "2";
    public static final String INPUT_NUMBER_LENGTH_EXCEPTION_MESSAGE = "입력값은 3자리 수만 가능합니다.";
    public static final String INPUT_NUMBER_RANGE_EXCEPTION_MESSAGE = "입력값은 1~9 범위의 숫자만 가능합니다.";
    public static final String INPUT_NUMBER_DUPLICATED_EXCEPTION_MESSAGE = "입력값은 중복되지 않는 서로 다른 숫자만 가능합니다.";
    public static final String CONTINUE_OR_EXIT_NUMBER_EXCEPTION_MESSAGE = "입력값은 1 또는 2 만 가능합니다.";
    public static final String CONTINUE_OR_EXIT_NUMBER_LENGTH_EXCEPTION_MESSAGE = "입력값은 한 자리 수만 입력 가능합니다.";

    public static String validateBaseBallNumber(String input) {
        validInputLength(input);
        validIsNumber(input);
        validIsDuplicated(input);
        return input;
    }

    private static void validInputLength(String input) {
        if (input.length() != INPUT_NUMBER_LENGTH) {
            throw new IllegalArgumentException(INPUT_NUMBER_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private static void validIsNumber(String input) {
        input.chars()
                .filter(c -> c < MIN_NUMBER || MAX_NUMBER < c)
                .findAny()
                .ifPresent(c -> {
                    throw new IllegalArgumentException(INPUT_NUMBER_RANGE_EXCEPTION_MESSAGE);
                });
    }

    private static void validIsDuplicated(String input) {
        long count = input.chars()
                .distinct()
                .count();
        if (count != INPUT_NUMBER_LENGTH) {
            throw new IllegalArgumentException(INPUT_NUMBER_DUPLICATED_EXCEPTION_MESSAGE);
        }
    }

    public static String validateContinueOrExitNumber(String input) {
        validContinueOrExitNumberLength(input);
        validIsContinueOrExitNumber(input);
        return input;
    }

    private static void validContinueOrExitNumberLength(String input) {
        if (input.length() != CONTINUE_OR_EXIT_NUMBER_LENGTH) {
            throw new IllegalArgumentException(CONTINUE_OR_EXIT_NUMBER_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private static void validIsContinueOrExitNumber(String input) {
        if (!input.equals(CONTINUE_NUMBER) && !input.equals(EXIT_NUMBER)) {
            throw new IllegalArgumentException(CONTINUE_OR_EXIT_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
