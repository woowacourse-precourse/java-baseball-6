package baseball.constants;


public final class AppConstants {
    public static final int NUM_DISIT_LIMIT = 3;
    public static final int NUM_BEGIN_RANGE = 1;
    public static final int NUM_END_RANGE = 9;
    public static final String REGEX_VALID_INPUT = "^(?!.*(.).*\\1)[1-9]{3}$";
    public static final String REGEX_CONTINUE_VALUE = "^(1|2)$";

    public static final String MSG_START_GAME = "숫자 야구 게임을 시작합니다.";
    public static final String MSG_RESTART_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String MSG_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    public static final String MSG_END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESULT_GAME_BALL = "볼";
    public static final String RESULT_GAME_STRIKE = "스트라이크";
    public static final String RESULT_GAME_NOTHING_MSG = "낫싱";

    public static final String ERR_INVALID_NUMBER_INPUT = "1~9 사이의 3자리 숫자를 입력해 주세요.";
    public static final String ERR_WRONG_INPUT = "잘못된 입력입니다. 다시 시도하세요.";
    public static final String ERR_INVALID_RESTART_VALUE = "1 또는 2를 입력해 주세요.";

    private AppConstants() {}
}