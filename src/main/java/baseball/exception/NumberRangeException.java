package baseball.exception;

import static baseball.enums.NumbersEnum.MAX_VALUE;
import static baseball.enums.NumbersEnum.MIN_VALUE;



public class NumberRangeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = String.format("숫자는 %d에서 %d사이여야 합니다.", MIN_VALUE.showValue(), MAX_VALUE.showValue());

    public NumberRangeException() {

        super(ERROR_MESSAGE);
    }
}
