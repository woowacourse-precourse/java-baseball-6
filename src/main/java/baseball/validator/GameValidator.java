package baseball.validator;

import static baseball.constant.ErrorConstant.INCORRECT_ERROR;
import static baseball.constant.GameConstant.REGULAR_EXPRESSION_INPUT_NUMBER;
import static baseball.constant.GameConstant.REGULAR_EXPRESSION_RESTART_OR_END_NUMBER;

/**
 * 사용자 입력 값 검증
 */

public class GameValidator {

    public static void errorValidate(String stringNumber) {
        if (!stringNumber.matches(REGULAR_EXPRESSION_INPUT_NUMBER)) {
            throw new IllegalArgumentException(INCORRECT_ERROR);
        }
    }

    public static void restartOrExitValueValidate(String restartOrExit) {
        if (!restartOrExit.matches(REGULAR_EXPRESSION_RESTART_OR_END_NUMBER)) {
            throw new IllegalArgumentException(INCORRECT_ERROR);
        }
    }
}
