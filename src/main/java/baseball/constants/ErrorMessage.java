package baseball.constants;

import static baseball.constants.GameOption.*;
import static baseball.constants.SystemOption.*;

public enum ErrorMessage {

    WRONG_INPUT_FORMAT("잘못된 값을 입력하였습니다."),
    WRONG_INPUT_LENGTH(ANSWER_NUMBER_LENGTH.getLength() + "자리 수를 입력해야합니다."),
    DUPLICATE_NUMBER_INPUT("서로 다른 " + ANSWER_NUMBER_LENGTH.getLength() + " 자리 수를 입력해야합니다."),
    WRONG_RESPONSE_AFTER_FINISH(RESTART_SYSTEM_VALUE + " 혹은 " + EXIT_SYSTEM_VALUE + " 를 입력해야합니다."),
    INPUT_HAS_ZERO("0을 포함한 입력은 허용되지 않습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
