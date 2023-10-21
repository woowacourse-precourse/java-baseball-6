package baseball.exception;

import baseball.Enum.ConsoleNumberSize;

public class IllegalCountException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "넣을수 있는 수의 개수는 " +
            ConsoleNumberSize.MAX_SIZE.getSize() +
            "개이어야 합니다.프로그램을 종료합니다.";

    public IllegalCountException() {
        super(DEFAULT_MESSAGE);
    }
}
