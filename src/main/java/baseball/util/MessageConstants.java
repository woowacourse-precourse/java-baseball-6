package baseball.util;

public enum MessageConstants {
    STARTING_MESSAGE("숫자 야구 게임을 시작합니다."),
    USER_INPUT_MESSAGE("숫자를 입력해주세요: ");

    private final String content;

    MessageConstants(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
