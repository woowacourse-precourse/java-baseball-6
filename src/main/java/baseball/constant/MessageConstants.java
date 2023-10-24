package baseball.constant;

import static baseball.constant.NumberConstants.EXIT_NUMBER_STRING;
import static baseball.constant.NumberConstants.MAX_VALUE;
import static baseball.constant.NumberConstants.MIN_VALUE;
import static baseball.constant.NumberConstants.ONE_LENGTH;
import static baseball.constant.NumberConstants.RESTART_NUMBER_STRING;
import static baseball.constant.NumberConstants.THREE_LENGTH;

public final class MessageConstants {

    public static final String BLANK = " ";
    public static final String CANNOT_INSTANTIATE = "인스턴스화할 수 없습니다.";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";
    public static final String START = "숫자 야구 게임을 시작합니다.";
    public static final String REQUEST = "숫자를 입력해주세요 : ";
    public static final String THREE_STRIKE = THREE_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String ASK_ONE_OR_TWO =
            "게임을 새로 시작하려면 " + RESTART_NUMBER_STRING + ", 종료하려면 " + EXIT_NUMBER_STRING
                    + "를 입력하세요.";
    public static final String NATURAL_NUMBER = "숫자는 " + MIN_VALUE + "에서 " + MAX_VALUE + "까지여야 합니다.";
    public static final String DUPLICATE_NUMBER = ": 중복된 숫자가 존재합니다.";
    public static final String NOT_NUMBER = "은 숫자가 아닙니다.";
    public static final String LENGTH_MUST_BE_ONE = "의 길이는 " + ONE_LENGTH + "이어야 합니다.";
    public static final String LENGTH_MUST_BE_THREE = "의 길이는 " + THREE_LENGTH + "이어야 합니다.";
    public static final String NUMBER_MUST_BE_ONE_OR_TWO =
            ": " + RESTART_NUMBER_STRING + " 또는 " + EXIT_NUMBER_STRING + "여야 합니다.";
    public static final String END = "게임 종료";
    public static final String NOT_RESTART_OR_EXIT = ": Restart와 Exit에 맞는 숫자가 아닙니다.";

    private MessageConstants() {
        throw new AssertionError(CANNOT_INSTANTIATE);
    }

}
