package baseball.exception;

import baseball.Enum.NumberSize;

public class IllegalCountException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "넣을수 있는 수의 개수는 " +
            NumberSize.MAX_SIZE.getSize() +
            "개이어야 합니다.프로그램을 종료합니다.";

    public IllegalCountException() {
        super(DEFAULT_MESSAGE);
    }
}
