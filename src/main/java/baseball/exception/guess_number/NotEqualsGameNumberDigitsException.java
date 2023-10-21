package baseball.exception.guess_number;

import static baseball.constant.Constant.BASEBALL_GAME_NUMBER_DIGIT;

public class NotEqualsGameNumberDigitsException extends IllegalArgumentException {

    public NotEqualsGameNumberDigitsException(final int digit) {
        super(digit + "자리 입력은 잘못된 입력 값입니다." + BASEBALL_GAME_NUMBER_DIGIT + "자리 숫자를 입력해주세요.");
    }
}
