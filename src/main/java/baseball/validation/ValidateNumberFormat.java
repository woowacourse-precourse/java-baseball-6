package baseball.validation;

import baseball.exception.InvalidNumberFormatException;

public class ValidateNumberFormat{
  public static Boolean validate(String value) {
    if (!value.matches("^[1-9]{3}$")) {
      throw new InvalidNumberFormatException();
    }
    return true;
  }
}
