package baseball.constant;

/**
 * 메시지 관련 상수 관리 클래스
 */
public class MessageConst {

    public static final String START_GAME_MSG = "숫자 야구 게임을 시작합니다.";

    public static final String USER_INPUT_MSG = "숫자를 입력해주세요 : ";

    public static final String BALL = "볼";

    public static final String STRIKE = "스트라이크";

    public static final String NOTHING = "낫싱";

    public static final String SUCCESS_MSG = NumberConst.SUCCESS_STRIKE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String RESTART_EXIT_MSG = "게임을 새로 시작하려면 " + NumberConst.RESTART_NUM +
            ", 종료하려면 " + NumberConst.EXIT_NUM + "를 입력하세요.";

    public static final String INPUT_RANGE_NATURAL_EXCEPTION_MSG = NumberConst.START_NUM + "~" +
            NumberConst.END_NUM + " 사이의 숫자를 입력해 주세요.";

    public static final String INPUT_LENGTH_EXCEPTION_MSG = NumberConst.INPUT_LENGTH + "개 이하를 입력해 주세요.";

    public static final String INPUT_DUPLICATE_EXCEPTION_MSG = "중복된 숫자를 입력할 수 없습니다.";

    public static final String INPUT_RESTART_EXIT_EXCEPTION_MSG = "재시작 할려면 " + NumberConst.RESTART_NUM +
            " 종료할려면 " + NumberConst.EXIT_NUM + "를 입력해주세요.";
}
