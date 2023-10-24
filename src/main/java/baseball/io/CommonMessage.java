package baseball.io;

public enum CommonMessage {
    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_INPUT("숫자를 입력해주세요 : "),
    GAME_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_END_ERROR("입력이 올바르지 않습니다 게임을 종료합니다.");

    private final String text;

    CommonMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
