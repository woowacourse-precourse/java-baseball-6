package baseball.core.code;


public enum Message {
    START("숫자 야구 게임을 시작합니다.")
    ;

    private String description;

    private Message(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
