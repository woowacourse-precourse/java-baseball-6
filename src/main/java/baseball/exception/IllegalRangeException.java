package baseball.exception;

import baseball.Enum.ConsoleNumberSize;

public class IllegalRangeException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "허용되는 숫자의 범위는 " +
        ConsoleNumberSize.START_INCLUSIVE.getSize() +
        " ~ " +
        ConsoleNumberSize.END_INCLUSIVE.getSize() +
        "입니다. 프로그램을 종료합니다.";

    public IllegalRangeException() {
        super(DEFAULT_MESSAGE);
    }
}
