package baseball;

public enum Message {
    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    REQUESTING_INPUT("숫자를 입력해주세요 : "),
    INPUT_STRING_ERROR("입력은 3자리 수여야 합니다."),
    INPUT_BOUND_ERROR("입력은 1 혹은 2여야 합니다."),
    THREE_STRIKE("3스트라이크");

    private String message;

    Message(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}