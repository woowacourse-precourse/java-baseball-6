package baseball.exception;

public class GameStateNumberValidator {

    private static final String LENGTH_NOT_ONE_MSG = "한 글자만 입력 가능합니다.";
    private static final String NOT_ONE_AND_TWO_MSG = "1 또는 2만 입력 가능합니다.";

    private GameStateNumberValidator() {
    }

    public static boolean isGameStateNumberValid(String input) {
        if (isLengthOne(input) && isEqualToOneOrTwo(input)) {
            return true;
        }
        return false;
    }

    private static boolean isLengthOne(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(LENGTH_NOT_ONE_MSG);
        }
        return true;
    }

    private static boolean isEqualToOneOrTwo(String input) {
        if (input.charAt(0) != '1' && input.charAt(0) != '2') {
            throw new IllegalArgumentException(NOT_ONE_AND_TWO_MSG);
        }
        return true;
    }
}
