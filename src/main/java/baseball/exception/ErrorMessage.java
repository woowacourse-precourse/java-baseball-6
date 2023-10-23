package baseball.exception;

import baseball.domain.Baseball;
import baseball.domain.Command;

public enum ErrorMessage {
    INVALID_INPUT_NUMBER("양의 정수를 입력해주세요."),
    INVALID_COMMAND(String.format("%s 또는 %s를 입력하세요.", Command.RETRY.getValue(), Command.EXIT.getValue())),
    DUPLICATED_NUMBERS("중복되지 않은 숫자를 입력하세요."),
    INVALID_LENGTH(String.format("%d자리 숫자를 입력하세요.", Baseball.NUMBERS_COUNT)),
    INVALID_RANGE(String.format("%d ~ %d 사이의 숫자를 입력하세요.", Baseball.MIN_NUMBER, Baseball.MAX_NUMBER));

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
