package baseball.constants;

public enum AppConstants {

    // 시스템 변수
    NUM_DISIT_LIMIT(3),
    NUM_BEGIN_RANGE(1),
    NUM_END_RANGE(9),
    REGEX_VALID_INPUT("^[1-9]{3}$"),
    REGEX_CONINUE_VALUE("^(1|2)$"),

    // 시스템 메시지
    MSG_START_GAME("숫자 야구 게임을 시작합니다."),
    MSG_RESTART_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    MSG_INPUT_NUMBER("숫자를 입력해주세요 : "),
    MSG_END_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESULT_GAME_BALL("볼"),
    RESULT_GAME_STRIKE("스트라이크"),
    RESULT_GAME_FAIL_MSG("낫싱"),

    // 오류 메시지
    ERR_INVALID_NUMBER_INPUT("1~9 사이의 3자리 숫자를 입력해 주세요."),
    ERR_WRONG_INPUT("잘못된 입력입니다. 다시 시도하세요."),
    ERR_INVALID_RESTART_VALUE("1 또는 2를 입력해 주세요");


    private final Object constant;

    AppConstants(Object constant) {
        this.constant = constant;
    }

    public Object getVal() {
        return this.constant;
    }
}