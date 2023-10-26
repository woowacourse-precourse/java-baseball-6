package baseball.util;

public enum ExceptionMessage {
    BASE("[ERROR] %s"),
    NOT_NUMERIC("입력 범위를 초과했습니다."),
    NOT_IN_RANGE("1부터 9까지의 숫자만 입력 가능합니다."),
    INVALID_BALL_COUNT("올바른 값을 입력해 주세요."),
    INVALID_GAME_COMMAND("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    INVALID_LENGTH("세 자리 자연수를 입력해 주세요."),
    INVALID_GAME_STATUS("해당하는 게임 상태가 없습니다.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
