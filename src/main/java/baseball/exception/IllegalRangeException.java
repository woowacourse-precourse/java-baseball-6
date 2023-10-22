package baseball.exception;

import baseball.Enum.ConsoleNumberSizeEnum;

public class IllegalRangeException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "허용되는 숫자의 범위는 " +
        ConsoleNumberSizeEnum.START_INCLUSIVE.getSize() +
        " ~ " +
        ConsoleNumberSizeEnum.END_INCLUSIVE.getSize() +
        "입니다. 프로그램을 종료합니다.";

    public IllegalRangeException() {
        super(DEFAULT_MESSAGE);
    }
}
