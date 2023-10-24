package baseball.domain.number;

import java.util.Objects;

public class Number {

  private static final String NUMERIC_RANGE_ERROR_MESSAGE = "숫자는 1부터 9까지만 가능합니다.";
  public static final int MIN_NUMERICAL_VALUE = 1;
  public static final int MAX_NUMERICAL_VALUE = 9;

  private final int value;

  public Number(final int number) {
    validate(number);
    this.value = number;
  }

  private void validate(final int number) {
    validateNumericRange(number);
  }

  private void validateNumericRange(final int number) {
    if (number < MIN_NUMERICAL_VALUE || number > MAX_NUMERICAL_VALUE) {
      throw new IllegalArgumentException(NUMERIC_RANGE_ERROR_MESSAGE);
    }
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj instanceof Number) {
      return value == ((Number) obj).value;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
}
