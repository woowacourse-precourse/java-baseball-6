package baseball.gameutil.validate;

import baseball.message.MessageString;

/**
 * ValidateInput 인터페이스를 구현한 클래스를 모드에 따라서 반환하는 팩토리 클래스
 */
public class ValidateInputFactory {

    private ValidateInputFactory() {
    }

    /**
     * 입력 모드에 따라서 ValidateInput 인터페이스를 구현한 클래스를 반환한다.
     * @param mod 입력 모드
     * @return 입력 모드에 따라서 ValidateInput 인터페이스를 구현한 클래스
     */
    public static ValidateInput getValidateInput(InputMod mod) {
        return switch (mod) {
            case GAME -> ValidateInputGame.getInstance();
            case RERUN -> ValidateInputRerun.getInstance();
            default -> throw new IllegalArgumentException(MessageString.WRONG_RERUN_INPUT_ERROR_STRING);
        };
    }
}
