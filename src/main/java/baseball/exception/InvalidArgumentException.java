package baseball.exception;

import baseball.domain.ErrorCode;

public class InvalidArgumentException extends IllegalArgumentException {

    public InvalidArgumentException(ErrorCode code) {
        super(code.getMessage());
    }
}
