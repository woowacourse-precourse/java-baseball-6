package baseball.constant;

public class MessageConst {
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String SUCCESS_GAME_MESSAGE = NumberConst.EXPECTED_INPUT_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String GAME_CONTROL_MESSAGE = "게임을 새로 시작하려면 " + NumberConst.RESTART_NUMBER +
            ", 종료하려면 " + NumberConst.STOP_NUMBER + "를 입력하세요.";
    public static final String BALL_MESSAGE = "볼";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String NOTHING_MESSAGE = "낫싱";
    public static final String INVALID_INPUT_LENGTH_MESSAGE = "유효하지 않은 숫자 길이입니다.";
    public static final String INVALID_INPUT_DUPLICATE_NUMBER_MESSAGE = "중복된 숫자가 있습니다.";
    public static final String INVALID_INPUT_IS_NUMERIC_MESSAGE = "숫자만 입력하세요.";
    public static final String INVALID_INPUT_RANGE_MESSAGE =
            NumberConst.MIN_INPUT_VALUE + "부터 " + NumberConst.MAX_INPUT_VALUE + "사이의 값만 입력하세요.";
    public static final String INVALID_RESTART_STOP_VALUE_MESSAGE = "1 또는 2 값을 입력하세요.";
}
