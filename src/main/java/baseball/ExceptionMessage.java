package baseball;

public enum ExceptionMessage {
    ILLEGAL_USER_INPUT_MESSAGE("야구공은 숫자만 입력할 수 있습니다."),
    ILLEGAL_GAME_INPUT_MESSAGE("공 번호는 1 또는 2만 입력할 수 있습니다."),
    ILLEGAL_BASEBALL_NUMBER_RANGE_MESSAGE("공 번호는 1부터 9까지만 입력할 수 있습니다."),
    ILLEGAL_BASEBALL_SIZE("공의 개수는 3개여야 합니다."),
    ILLEGAL_UNIQUE_BASEBALL_GROUP("모든 공은 서로 다른 임의의 숫자여야 합니다.")
    ;

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
