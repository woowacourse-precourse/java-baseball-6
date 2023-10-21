package baseball.exception.guess_number;

public class NotMatchGameNumberFormatException extends IllegalArgumentException {

    public NotMatchGameNumberFormatException(final int invalidNumber) {
        super(invalidNumber + "은(는) 잘못된 입력입니다. 1부터 9까지의 숫자중에서 입력해주세요.");
    }
}
