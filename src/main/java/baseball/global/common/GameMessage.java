package baseball.global.common;

public enum GameMessage {

    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다.\n"),
    INPUT_NUMBER_MESSAGE("숫자를 입력해주세요 : "),
    NOTHING_COUNT_MESSAGE("낫싱"),
    BALL_COUNT_MESSAGE("볼"),
    STRIKE_COUNT_MESSAGE("스트라이크"),
    GAME_ENDED_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    RESTART_GAME_OR_EXIT_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

    public final String message;

    GameMessage(String message) {
        this.message = message;
    }
}
