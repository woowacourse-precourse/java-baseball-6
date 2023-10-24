package baseball.domain.number;

import java.util.List;
import java.util.stream.Collectors;

public class InputNumbers {

  private static final String NON_NUMERIC_ERROR_MESSAGE = "숫자가 아닌 값이 포함되어 있습니다.";
  private static final String DIGIT_SIZE_ERROR_MESSAGE = "자리의 숫자가 아닙니다.";
  private static final String DISTINCT_ERROR_MESSAGE = "중복된 값이 있습니다.";
  public static final int INPUT_NUMBER_LENGTH = 3;

  private final List<Number> numbers;

  private InputNumbers(final String input) {
    validate(input);
    this.numbers = parseNumbers(input);
  }

  public static InputNumbers of(final String input) {
    return new InputNumbers(input);
  }

  private void validate(final String input) {
    isNumeric(input);
    isThreeDigitsNumber(input);
    isDistinct(input);
  }

  private void isNumeric(final String input) {
    try {
      Integer.parseInt(input);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
    }
  }

  private void isThreeDigitsNumber(final String input) {
    if (input.length() != INPUT_NUMBER_LENGTH) {
      throw new IllegalArgumentException(INPUT_NUMBER_LENGTH + DIGIT_SIZE_ERROR_MESSAGE);
    }
  }

  private void isDistinct(final String input) {
    int distinctCount = (int) input.chars()
        .distinct()
        .count();
    if (input.length() != distinctCount) {
      throw new IllegalArgumentException(DISTINCT_ERROR_MESSAGE);
    }
  }

  private List<Number> parseNumbers(final String input) {
    return input.chars()
        .map(Character::getNumericValue)
        .mapToObj(Number::new)
        .collect(Collectors.toList());
  }

  public Number get(int index) {
    return numbers.get(index);
  }
}
