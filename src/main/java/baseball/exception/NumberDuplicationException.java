package baseball.exception;

import static baseball.enums.NumbersEnum.MAX_VALUE;
import static baseball.enums.NumbersEnum.MIN_VALUE;

public class NumberDuplicationException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = String.format("게임에 사용되는 숫자들 중 중복된 숫자가 있으면 안됩니다.");

    public NumberDuplicationException() {
        super(ERROR_MESSAGE);
    }
}
