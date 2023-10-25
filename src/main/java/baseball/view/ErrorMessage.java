package baseball.view;

public enum ErrorMessage {
    INVALID_NUMBER_LENGTH("숫자 야구는 3자리여야 합니다."),
    INVALID_DUPLICATE_NUMBER("숫자 야구는 각 자리가 중복될 수 없습니다."),
    INVALID_GAME_KEEP_GOING_INPUT("종료 또는 재시작을 위해선 1과 2 중 선택해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
