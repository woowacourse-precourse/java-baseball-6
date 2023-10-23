package baseball;

public enum Message {

    GAME_START("숫자 야구 게임을 시작합니다."),
    INSERT_GAME_INPUT("숫자를 입력해주세요 : "),
    USER_WIN("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    NOTHING("낫싱"),
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
