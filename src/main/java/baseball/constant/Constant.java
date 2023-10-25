package baseball.constant;

public class Constant {
    public static final String INIT_GAME_MSG = "숫자 야구 게임을 시작합니다.";
    public static final String END_GAME_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String INPUT_NUMBERS_MSG = "숫자를 입력해주세요 : ";
    public static final String INPUT_COMMAND_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";
    public static final String INVALID_LENGTH_EXCEPTION_MSG = "입력한 숫자의 길이를 확인하세요.";
    public static final String INVALID_RANGE_EXCEPTION_MSG = "입력 값의 범위(1~9)를 확인하세요.";
    public static final String INVALID_DUPLICATE_EXCEPTION_MSG = "중복된 숫자가 존재합니다.";
    public static final String INVALID_COMMAND_EXCEPTION_MSG = "명령어를 확인하세요. 1 (재시작), 2 (종료)";

    public static final int NUMBER_LENGTH = 3;
    public static final int INPUT_MIN_VALUE = 1;
    public static final int INPUT_MAX_VALUE = 9;
    public static final int ALL_STRIKE = 3;
    public static final int COMMAND_RESTART = 1;
    public static final int COMMAND_EXIT = 2;
}
