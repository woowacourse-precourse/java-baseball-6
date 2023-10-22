package baseball.validation;

import baseball.exception.InvalidNumberFormatException;

public class ValidateRetryCheckNumber {
  public static void validate(String value) {
    if (!value.matches("^[1-2]{1}$")) {
      throw new InvalidNumberFormatException();
    }
  }
}
