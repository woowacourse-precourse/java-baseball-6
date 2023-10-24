package baseball.console;

public class Constant {

    static final String INPUT_BASEBALL_GAME_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    static final String INPUT_BASEBALL_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    static final String START_BASEBALL_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    static final String TERMINATION_BASEBALL_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String EXCEPTION_BASEBALL_NUMBER_FORMAT_MESSAGE = "숫자는 1~9 범위 내로 입력하세요.";
    public static final String EXCEPTION_BASEBALL_NUMBERS_SIZE_MESSAGE = "3개의 숫자를 입력하세요.";
    public static final String EXCEPTION_BASEBALL_NUMBERS_DUPLICATE_MESSAGE = "중복된 숫자가 존재합니다.";
    public static final String EXCEPTION_RESTART_CONDITION_FORMAT_MESSAGE = "게임 종료 여부는 1 또는 2로만 입력하세요.";

    public static final char CHAR_ZERO = '0';
    public static final int INT_ZERO = 0;

    public static final String RESULT_NOTHING = "낫싱";
    public static final String RESULT_STRIKE = "스트라이크";
    public static final String RESULT_BALL = "볼";
}
