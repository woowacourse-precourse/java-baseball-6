package baseball.constant;

public enum GameMessage {
    GAME_START("숫자 야구 게임을 시작합니다."),
    NUMBER_INPUT_REQUEST("숫자를 입력해주세요 : "),
    SUCCESS("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RETRY_INPUT_REQUEST(
            String.format(
                    "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.",
                    RetryStatus.KEEP_GOING.toCommand(), RetryStatus.FINISH.toCommand()));

    private final String message;

    GameMessage(final String message) {
        this.message = message;
    }

    public String toValue() {
        return this.message;
    }
}
