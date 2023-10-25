package constant;

public enum GameMessage {
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
    PLAYER_INPUT_MESSAGE("숫자를 입력해주세요 : "),
    CORRECT_ANSWER_MESSAGE(Constant.BASEBALL_GAME_NUMBER_LENGTH.getValue() + "개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    RESTART_INPUT_MESSAGE(
            "게임을 새로 시작하려면 " + Constant.RESTART_VALUE.getValue() + ", 종료하려면 " + Constant.FINISH_GAME_VALUE.getValue()
                    + "를 입력하세요.");

    private String message;

    private GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
