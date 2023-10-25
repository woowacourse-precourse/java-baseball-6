package baseball.gameutil.validate;

import baseball.Constant;
import baseball.message.MessageString;

/**
 * 게임 진행 중에 숫자를 받는 입력을 검증하는 클래스
 */
public class ValidateInputGame extends ValidateInputCommon implements ValidateInput {

    private static ValidateInputGame INSTANCE;

    private ValidateInputGame() {
    }

    /**
     * 싱글톤 패턴으로 생성 된 인스턴스를 반환한다.
     */
    public static ValidateInputGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ValidateInputGame();
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
        if (!checkLength(input, Constant.NUMBER_LENGTH)) {
            throw new IllegalArgumentException(MessageString.GAME_LEN_ERROR_STRING);
        }
        if (!checkIsAllNumber(input)) {
            throw new IllegalArgumentException(MessageString.WRONG_GAME_INPUT_ERROR_STRING);
        }
        if (!checkBetween(input, Constant.NUMBER_MIN, Constant.NUMBER_MAX)) {
            throw new IllegalArgumentException(MessageString.WRONG_GAME_INPUT_ERROR_STRING);
        }
        if (!checkUnique(input)) {
            throw new IllegalArgumentException(MessageString.WRONG_GAME_INPUT_ERROR_STRING);
        }
        return input;
    }
}

