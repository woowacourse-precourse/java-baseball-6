package baseball.Exception;

public enum InputException {
    NOT_NUMBER("입력은 1에서 9까지의 숫자만 가능합니다."),
    NOT_THREE("입력은 3개의 숫자만 가능합니다."),
    HAS_DUPLICATE_NUMBER("입력은 서로 다른 숫자만 가능합니다."),
    WRONG_COMMAND("재시작은 1, 종료는 2를 입력해주세요");

    private String message;

    InputException(String message) {
        this.message = message;
    }
}
