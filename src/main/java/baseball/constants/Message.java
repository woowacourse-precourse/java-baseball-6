package baseball.constants;

public enum Message {
    GAME_START("숫자 야구 게임을 시작합니다."),
    INPUT("숫자를 입력해주세요 : "),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ASK_COMMAND("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    STRIKE("%d스트라이크 "),
    BALL("%d볼 "),
    NOTHING("낫싱");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

    public String of(Integer amount) {
        if (this != STRIKE && this != BALL) {
            throw new IllegalArgumentException(ErrorCode.NOT_SUPPORTED_OPERATION.toString());
        }
        if (amount.equals(0)) {
            return "";
        }
        return String.format(this.message, amount);
    }
}
