package baseball.message;

public enum Message {
    FIRST_GAME_START("숫자 야구 게임을 시작합니다."),
    CORRECT_ANSWER("3스트라이크\n" +
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    ;

    private String content;

    Message(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
