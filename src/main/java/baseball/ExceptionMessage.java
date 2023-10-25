package baseball;

import static baseball.Constant.END_NUMBER;
import static baseball.Constant.PLAY_NUMBER_DIGIT;
import static baseball.Constant.START_NUMBER;

public enum ExceptionMessage {

    PLAY_NUMBER_LENGTH_EXCEPTION("길이는 " + PLAY_NUMBER_DIGIT.getValue() + "이어야 합니다."),
    PLAY_NUMBER_DUPLICATE_EXCEPTION("숫자들이 중복되면 안 됩니다."),
    PLAY_NUMBER_VALUE_EXCEPTION(START_NUMBER.getValue() + " ~ " + END_NUMBER.getValue() + " 사이의 값이어야만 합니다."),
    RESUME_VALUE_EXCEPTION("재시작/종료 입력값이 잘못되었습니다.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
