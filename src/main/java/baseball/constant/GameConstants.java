package baseball.constant;

public final class GameConstants {
    public static final String ERROR_INVALID_INPUT = "[ERROR] 잘못된 숫자 입력입니다: ";
    public static final String ERROR_INVALID_CONTINUE_INPUT = "[ERROR] 1 또는 2 를 입력하세요.";
    public static final String INPUT_REGEX = "^[1-9]{3}$";
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int MAX_NUMBER_LENGTH = 3;

    private GameConstants() {
    }
}

