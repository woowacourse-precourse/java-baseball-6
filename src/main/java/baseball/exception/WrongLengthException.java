package baseball.exception;

import static baseball.enums.NumbersEnum.*;

import baseball.enums.NumbersEnum;

public class WrongLengthException extends IllegalArgumentException{
    private static String ERROR_MESSAGE = String.format("Numbers의 길이는 %d이여야 합니다.", LENGTH.showValue());

    public WrongLengthException() {
        super(ERROR_MESSAGE);
    }
}
