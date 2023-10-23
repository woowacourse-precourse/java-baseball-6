package baseball.validator;

import static baseball.ConstValue.GAME_RETRY_INPUT_ONE_OR_TWO_EXCEPTION;
import static baseball.ConstValue.PLAY_CONTINUE;
import static baseball.ConstValue.PLAY_STOP;

public class GameRetryInputValidator implements InputValidator {
    @Override
    public void validateInput(String input) {
        // 1 또는 2 이외의 값 입력시 IllegalArgumentException 발생
        if (!input.equals(PLAY_CONTINUE) && !input.equals(PLAY_STOP)) {
            throw new IllegalArgumentException(GAME_RETRY_INPUT_ONE_OR_TWO_EXCEPTION);
        }
    }
}
