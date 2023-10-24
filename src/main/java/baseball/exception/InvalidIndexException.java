package baseball.exception;

import baseball.constant.ErrorMessage;

public class InvalidIndexException extends IllegalArgumentException {

    public InvalidIndexException() {
        super(ErrorMessage.INVALID_INDEX_ERROR.toString());
    }
}
