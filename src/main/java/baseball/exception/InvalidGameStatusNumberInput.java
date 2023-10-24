package baseball.exception;

public final class InvalidGameStatusNumberInput extends IllegalArgumentException {

    public static final String INVALID_GAME_STATUS_INPUT_MESSAGE = "유효하지 않은 입력입니다.\n재시작 여부는 반드시 1, 2 중 하나를 입력하셔야 합니다.";

    public InvalidGameStatusNumberInput() {
        super(INVALID_GAME_STATUS_INPUT_MESSAGE);
    }
}
