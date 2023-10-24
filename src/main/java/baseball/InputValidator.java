package baseball;

public class InputValidator {

    public static void isValidUserNumberInput(String input) {
        checkLength(input);
        checkNumeric(input);
        checkDistinctDigits(input);
    }

    public static void isValidUserAnswerInput(String input) {
        checkZeroOrOne(input);
    }

    private static void checkLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자를 입력하세요.");
        }
    }

    private static void checkNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }
    }

    private static void checkDistinctDigits(String input) {
        if (input.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("세 자리 서로 다른 숫자를 입력하세요.");
        }
    }

    private static void checkZeroOrOne(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("잘못된 답을 하셨습니다.");
        }
    }
}
