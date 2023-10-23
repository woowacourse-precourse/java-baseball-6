package baseball;

public enum ErrorMessage {
    NOT_NUMERIC("숫자가 아닌 값입니다. 숫자를 입력해주세요."),
    OUT_OF_RANGE("3자리 자연수를 입력해주세요."),
    WRONG_RESET_COMMAND("잘못된 숫자입니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    DUPLICATE_NUMBER("각 자리의 숫자는 서로 달라야합니다."),
    ZERO_CONTAIN("숫자에 0이 포함될 수 없습니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = String.format(message);
    }

    public String getMessage() {
        return message;
    }
}
