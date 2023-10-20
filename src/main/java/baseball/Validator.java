package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validator {
  private static final int INPUT_NUMBERS_SIZE = 3;
  private static final String INVALID_NUMBER_SIZE = "숫자의 길이는 3입니다.";
  private static final String INVALID_NUMERIC_NUMBER = "입력은 숫자만 가능합니다.";
  private static final String INVALID_DUPLICATED_NUMBER = "중복된 수가 존재합니다.";

  public static void validateInputNumbersSize(String numbers) {
    if (numbers.length() != INPUT_NUMBERS_SIZE) {
      throw new IllegalArgumentException(INVALID_NUMBER_SIZE);
    }
  }

  public static void validateIsNumeric(String numbers) {
    for (char number : numbers.toCharArray()) {
      if (!Character.isDigit(number)) {
        throw new IllegalArgumentException(INVALID_NUMERIC_NUMBER);
      }
    }
  }

  public static void vaildateInputNumbersDuplicated(String numbers) {
    Set<Character> set = new HashSet<>();
    for (char number : numbers.toCharArray()) {
      if (set.contains(number)) {
        throw new IllegalArgumentException(INVALID_DUPLICATED_NUMBER);
      }
    }
  }
}
