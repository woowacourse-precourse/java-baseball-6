package baseball;

public enum GameMessage {
    GAME_START("숫자 야구 게임을 시작합니다."),
    NUMBER_INPUT("숫자를 입력해주세요 : "),
    // TODO: 입력받을 자리수에 따라 유동적 vs 그냥 하드코딩
    GAME_END("개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    // TODO: 입력받을 값에 따라 유동적 vs 그냥 하드코딩
    RETRY_INPUT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
