package baseball;

/**
 * 상수 관리
 */
public class Constant {
    // 게임 진행 메시지
    public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    // 숫자 생성
    public static final int GENERATE_MIN_VALUE = 1;
    public static final int GENERATE_MAX_VALUE = 9;
    public static final int GENERATE_NUM_SIZE = 3;

    // 게임 재시작 or 종료
    public static final int RESTART_OPTION = 1;
    public static final int END_OPTION = 2;

    // 힌트
    public static final String BALL_STR = "볼";
    public static final String STRIKE_STR = "스트라이크";
    public static final String NOTHING_STR = "낫싱";

    // 에러 메시지
    public static final String NOT_NUMBER_ERROR_MESSAGE = "문자가 아닌 숫자를 입력하세요";
    public static final String NOT_LENGTH_ERROR_MESSAGE = "%d자리 숫자를 입력하세요";
    public static final String OUT_OF_RANGE_ERROR_MESSAGE = "%d~%d사이의 숫자를 입력하세요";
    public static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "중복되지 않는 숫자를 입력하세요";
    public static final String NOT_OPTION_NUMBER_ERROR_MESSAGE = "올바른 숫자를 입력하세요";
}
