package baseball.util.exception;

import static baseball.domain.enums.Constants.NUM_SIZE;

public class invaildInputLengthException extends IllegalArgumentException {
    private static final String INVAILD_INPUT_LENGTH = "입력 길이는 " + NUM_SIZE.getValue() + "자리만 가능합니다.";

    public invaildInputLengthException() {
        super(INVAILD_INPUT_LENGTH);
    }
}
