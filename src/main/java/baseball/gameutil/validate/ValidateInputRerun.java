package baseball.gameutil.validate;

import baseball.Constant;
import baseball.message.MessageString;

/**
 * 게임 재시작 여부를 받는 입력을 검증하는 클래스
 */
public class ValidateInputRerun extends ValidateInputCommon implements ValidateInput {

    private static ValidateInputRerun INSTANCE;

    private ValidateInputRerun() {
    }

    /**
     * 싱글톤 패턴으로 생성 된 인스턴스를 반환한다.
     */
    public static ValidateInputRerun getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ValidateInputRerun();
        }
        return INSTANCE;
    }

    /**
     * 입력값을 검증한다.
     * @param input 입력값
     * @return 입력값
     */
    @Override
    public String validate(String input) {
        if (!checkLength(input, Constant.RESTART_MODE_LENGTH)) {
            throw new IllegalArgumentException(MessageString.WRONG_RERUN_INPUT_ERROR_STRING);
        }
        if (!checkIsAllNumber(input)) {
            throw new IllegalArgumentException(MessageString.WRONG_RERUN_INPUT_ERROR_STRING);
        }
        if (!checkBetween(input, Constant.RESTART_RESTART, Constant.RESTART_END)) {
            throw new IllegalArgumentException(MessageString.WRONG_RERUN_INPUT_ERROR_STRING);
        }
        return input;
    }
}
