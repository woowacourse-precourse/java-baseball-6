package baseball.constant;

public final class GameConstants {
    public static final String ERROR_INVALID_INPUT = "[ERROR] 잘못된 숫자 입력입니다: ";
    public static final String ERROR_INVALID_CONTINUE_INPUT =
            "[ERROR] " + GameStatus.CONTINUE.status + " 또는 " + GameStatus.STOP.status + " 를 입력하세요.";
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int MAX_NUMBER_LENGTH = 3;
    public static final String INPUT_REGEX = "^[" + MIN_NUMBER + "-" + MAX_NUMBER + "]{" + MAX_NUMBER_LENGTH + "}$";

    private GameConstants() {
    }
}

