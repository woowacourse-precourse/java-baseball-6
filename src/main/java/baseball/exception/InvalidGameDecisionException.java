package baseball.exception;

import baseball.constant.ErrorMessage;

public class InvalidGameDecisionException extends IllegalArgumentException {

    public InvalidGameDecisionException() {
        super(ErrorMessage.GAME_DECISION_INPUT_ERROR.toString());
    }
}
