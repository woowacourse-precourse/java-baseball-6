package baseball;

public enum Message {
    GAME_START("숫자 야구 게임을 시작합니다."),
    INSERT_GAME_INPUT("숫자를 입력해주세요 : "),
    INSERT_END_INPUT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String text;

    Message(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }

    public boolean isNeedPrint() {
        return this.equals(INSERT_GAME_INPUT);
    }
}
