package baseball;
public class InputValidator {

    private static final int REQUIRED_NUMBER_LENGTH = 3;
    private static final String REQUIRED_NUMBER_MESSAGE = "세 자리 숫자를 입력하세요.";
    private static final String NUMERIC_INPUT_MESSAGE = "숫자만 입력하세요.";
    private static final String DISTINCT_DIGITS_MESSAGE = "세 자리 서로 다른 숫자를 입력하세요.";
    private static final String INVALID_ANSWER_MESSAGE = "잘못된 답을 하셨습니다.";

    public static void isValidUserNumberInput(String input) {
        checkLength(input);
        checkNumeric(input);
        checkDistinctDigits(input);
    }

    public static void isValidUserAnswerInput(String input) {
        checkZeroOrOne(input);
    }

    private static void checkLength(String input) {
        if (input.length() != REQUIRED_NUMBER_LENGTH) {
            throw new IllegalArgumentException(REQUIRED_NUMBER_MESSAGE);
        }
    }

    private static void checkNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(NUMERIC_INPUT_MESSAGE);
        }
    }

    private static void checkDistinctDigits(String input) {
        if (input.chars().distinct().count() != REQUIRED_NUMBER_LENGTH) {
            throw new IllegalArgumentException(DISTINCT_DIGITS_MESSAGE);
        }
    }

    private static void checkZeroOrOne(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException(INVALID_ANSWER_MESSAGE);
        }
    }
}