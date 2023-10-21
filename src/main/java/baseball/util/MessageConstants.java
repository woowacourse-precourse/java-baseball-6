package baseball.util;

public enum MessageConstants {
    STARTING_MESSAGE("숫자 야구 게임을 시작합니다."),
    USER_INPUT_MESSAGE("숫자를 입력해주세요: "),
    STRIKE_MESSAGE("스트라이크"),
    BALL_MESSAGE("볼"),
    SUCCESS_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    NO_STRIKE_NO_BALL_MESSAGE("낫싱"),
    GAME_CHOICE_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String content;

    MessageConstants(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
