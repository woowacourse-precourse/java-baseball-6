package baseball.validator;

public class InputValidator {

    private InputValidator() {
    }

    public static void isValidInput(String input) {
        //예외처리
        validateSize(input);
        validateNumber(input);
        validateDistinct(input);
    }

    public static void isValidRestart(String restart) {
        if (!restart.equals("1") && !restart.equals("2")) {
            throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }
    }

    private static void validateSize(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("숫자는 3자리만 입력 가능합니다.");
        }
    }

    private static void validateNumber(String input) {
        if (input.chars().anyMatch(c -> c < '1' || c > '9')) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static void validateDistinct(String input) {
        if (input.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }
}
