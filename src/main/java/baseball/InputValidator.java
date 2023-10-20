package baseball;


public class InputValidator {

    public static final int INPUT_NUMBER_LENGTH = 3;
    public static final char MIN_NUMBER = '1';
    public static final char MAX_NUMBER = '9';
    public static final String INPUT_NUMBER_LENGTH_EXCEPTION_MESSAGE = "입력값은 3자리 수만 가능합니다.";
    public static final String INPUT_NUMBER_RANGE_EXCEPTION_MESSAGE = "입력값은 1~9 범위의 숫자만 가능합니다.";
    public static final String INPUT_NUMBER_DUPLICATED_EXCEPTION_MESSAGE = "입력값은 중복되지 않는 서로 다른 숫자만 가능합니다.";

    public static void validate(String input) {
        validInputLength(input);
        validIsNumber(input);
        validIsDuplicated(input);
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
        if (count != 3) {
            throw new IllegalArgumentException(INPUT_NUMBER_DUPLICATED_EXCEPTION_MESSAGE);
        }
    }
}
