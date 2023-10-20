package baseball;

public enum ProgressMessage {
    START_BASEBALL_GAME("숫자 야구 게임을 시작합니다."),
    INPUT_EXPECTED_NUMBER("숫자를 입력해주세요 : "),
    CLEAR_BASEBALL_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    private final String message;

    ProgressMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
