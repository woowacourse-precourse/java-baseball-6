package baseball.common.exception;

import static baseball.config.BaseBallGameConfig.BASEBALL_MAX_NUMBER;
import static baseball.config.BaseBallGameConfig.BASEBALL_MIN_NUMBER;
import static baseball.config.BaseBallGameConfig.BASEBALL_NUMBER_SIZE;

public enum BaseBallExceptionMessage {

    INVALID_LENGTH(String.format("입력된 숫자는 %d 자리여야 합니다.", BASEBALL_NUMBER_SIZE.getValue())),
    OUT_OF_RANGE(String.format("입력된 숫자는 %d ~ %d 사이의 값이어야 합니다.",
            BASEBALL_MIN_NUMBER.getValue(),
            BASEBALL_MAX_NUMBER.getValue())),
    NOT_A_NUMBER("입력은 숫자 로만 이루어 져야 합니다."),
    INVALID_COMMAND("잘못된 명령어가 입력되었습니다.");

    final String exceptionMessage;

    BaseBallExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
