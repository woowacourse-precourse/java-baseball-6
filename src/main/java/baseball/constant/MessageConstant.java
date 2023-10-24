package baseball.constant;

public enum MessageConstant {

    INTRO_MESSAGE("숫자 야구 게임을 시작합니다."),
    REQUIRE_USER_INPUT("숫자를 입력해주세요: "),
    NOTHING("낫싱"),
    STRIKE("스트라이크"),
    BALL("볼"),
    GAME_OVER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_OR_EXIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

    public final String message;

    MessageConstant(String s) {
        this.message = s;
    }
}
