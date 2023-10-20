package baseball.exception;

public class InvalidNumberFormatException extends IllegalArgumentException{

  private static final String INVALID_NUMBER_FORMAT_MESSAGE = "[에러] 입력된 값이 올바른 숫자 형식이 아닙니다.";

  public InvalidNumberFormatException() {
    super(INVALID_NUMBER_FORMAT_MESSAGE);
  }

}
