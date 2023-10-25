package baseball.global.message;

public enum InGameMessage {
    START_BASEBALL("숫자 야구 게임을 시작합니다."),
    INPUT_THREE_NUMBER("숫자를 입력해주세요 : "),
    THREE_NUMBER_ALL_MATCH("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RETRY_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    final String message;

    InGameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
