package baseball.constant;

/**
 * 메시지 상수 클래스
 */
public final class MessageConst {

    public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static final String BALL = "볼";

    public static final String STRIKE = "스트라이크";

    public static final String NOTHING = "낫싱";

    public static final String SUCCESS_MESSAGE = NumberConst.INPUT_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String GAME_CONTROL_MESSAGE = "게임을 새로 시작하려면 " + NumberConst.RESTART_NUMBER +
            ", 종료하려면 " + NumberConst.EXIT_NUMBER + "를 입력하세요.";

    public static final String INPUT_LENGTH_EXCEPTION_MESSAGE = NumberConst.INPUT_LENGTH + "글자를 입력해 주세요.";

    public static final String INPUT_RANGE_EXCEPTION_MESSAGE = NumberConst.FIRST_RANGE + "부터 " +
            NumberConst.LAST_RANGE + "까지의 숫자를 입력해 주세요.";

    public static final String INPUT_DUPLICATE_EXCEPTION_MSG = "중복된 숫자는 입력할 수 없습니다.";

    public static final String GAME_CONTROL_EXCEPTION_MSG = NumberConst.RESTART_NUMBER + "(재시작) 혹은 " +
            NumberConst.EXIT_NUMBER + "(종료)를 입력해 주세요.";
}
