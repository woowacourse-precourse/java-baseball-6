package baseball;

import static baseball.NumberBaseballGameConfig.CONTINUE_GAME;
import static baseball.NumberBaseballGameConfig.EXIT_GAME;

public class ContinueModeNumberValidator implements InputValidator {

    @Override
    public void validate(String input) {
        checkType(input);
        checkModeNumber(input);
    }

    // 지정된 모드 넘버인지 확인
    private static void checkModeNumber(String input) {
        if (Integer.parseInt(input) != EXIT_GAME && Integer.parseInt(input) != CONTINUE_GAME) {
            throw new IllegalArgumentException();
        }
    }

    // 타입 확인
    private static void checkType(String input) {
        try {
            Integer.parseInt(input);
            return;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
