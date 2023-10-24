package baseball.constant;

import static baseball.constant.NumberConstant.EXIT_NUM;
import static baseball.constant.NumberConstant.INPUT_LENGTH;
import static baseball.constant.NumberConstant.MAXIMUM_RANGE_NUMBER;
import static baseball.constant.NumberConstant.MINIMUM_RANGE_NUMBER;
import static baseball.constant.NumberConstant.RESTART_NUM;

public class MessageConstant {
    public static final String STRIKE_MSG = "스트라이크";
    public static final String BALL_MSG = "볼";
    public static final String NOTHING_MSG = "낫싱";
    public static final String START_BASEBALL_MSG = "숫자 야구 게임을 시작합니다.";
    public static final String END_BASEBALL_MSG = INPUT_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_OR_EXIT_MSG = "게임을 새로 시작하려면 " + RESTART_NUM + ", 종료하려면 " + EXIT_NUM + "를 입력하세요.";
    public static final String PLEASE_INPUT_MSG = "숫자를 입력해주세요 : ";
    public static final String BLANK_EXCEPTION_MSG = "공백을 입력하였습니다.";
    public static final String NON_DIGIT_EXCEPTION_MSG = "숫자를 입력해주세요.";
    public static final String INPUT_LENGTH_EXCEPTION_MSG = INPUT_LENGTH + "자리 숫자를 입력해주세요.";
    public static final String NUMBER_RANGE_EXCEPTION_MSG =
            MINIMUM_RANGE_NUMBER + "에서 " + MAXIMUM_RANGE_NUMBER + "사이의 숫자를 입력해주세요.";
    public static final String NUMBER_DUPLICATE_EXCEPTION_MSG = "서로 다른 숫자를 입력해주세요.";
    public static final String INVALID_CHOICE_EXCEPTION_MSG = RESTART_NUM + " 혹은 " + EXIT_NUM + "를 선택해주세요.";
}
