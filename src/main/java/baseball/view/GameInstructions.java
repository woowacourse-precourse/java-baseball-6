package baseball.view;

public enum GameInstructions {
    GUIDE_GAME_START("숫자 야구 게임을 시작합니다."),
    GUIDE_GAME_SUCCESS("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ASK_INPUT_THREE_DIGIT_NUMBERS("숫자를 입력해주세요 : "),
    ASK_RESTART_OR_EXIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    GameInstructions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
