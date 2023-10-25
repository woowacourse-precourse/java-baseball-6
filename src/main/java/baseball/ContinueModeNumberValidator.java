package baseball;

import static baseball.NumberBaseballGameConfig.CONTINUE_GAME;
import static baseball.NumberBaseballGameConfig.ERROR_RANGE;
import static baseball.NumberBaseballGameConfig.ERROR_TYPE;
import static baseball.NumberBaseballGameConfig.EXIT_GAME;
import static baseball.TypeChecker.canConvertToInteger;

public class ContinueModeNumberValidator implements InputValidator {

    @Override
    public void validate(String input) {
        checkType(input);
        checkModeNumber(input);
    }

    // 지정된 모드 넘버인지 확인
    private void checkModeNumber(String input) {
        if (Integer.parseInt(input) != EXIT_GAME && Integer.parseInt(input) != CONTINUE_GAME) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }

    // 타입 확인
    private void checkType(String input) {
        if (!canConvertToInteger(input)) {
            throw new IllegalArgumentException(ERROR_TYPE);
        }
    }

}
