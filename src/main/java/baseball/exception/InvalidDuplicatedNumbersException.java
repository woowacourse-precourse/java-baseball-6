package baseball.exception;

public class InvalidDuplicatedNumbersException extends IllegalArgumentException{
  private static final String INVALID_DUPLICATED_NUMBERS_MESSAGE = "[에러] 입력된 값에 중복된 숫자가 있습니다.";

  public InvalidDuplicatedNumbersException() {
    super(INVALID_DUPLICATED_NUMBERS_MESSAGE);
  }
}
