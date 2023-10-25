package baseball.exception;

public enum BaseballExceptionType {
    INVALID_NUMBER_COUNT("세 개의 숫자를 입력해주세요."),
    OUT_OF_RANGE("1부터 9까지의 숫자를 입력해주세요."),
    DUPLICATE_NUMBER("중복된 숫자를 입력하셨습니다."),
    INVALID_GAME_OPTION("1(재시작) 또는 2(종료)를 입력해주세요.");

    private final String message;

    BaseballExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
