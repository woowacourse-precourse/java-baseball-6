package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validator {
  private static final int INPUT_NUMBERS_SIZE = 3;
  private static final int INPUT_RESTART_NUMBER = 1;
  private static final int INPUT_END_NUMBER = 2;

  private static final String INVALID_NUMBER_SIZE = "입력 길이는 3만 가능합니다.";
  private static final String INVALID_NUMERIC_NUMBER = "숫자만 입력해주세요.";
  private static final String INVALID_DUPLICATED_NUMBER = "입력에 중복된 수가 존재합니다.";
  private static final String INVALID_RESTART_AND_END_NUMBER = "1(재시작) 또는 2(종료)를 입력해주세요.";

  public void validateInputNumbersSize(String numbers) {
    if (numbers.length() != INPUT_NUMBERS_SIZE) {
      throw new IllegalArgumentException(INVALID_NUMBER_SIZE);
    }
  }

  public void validateInputNumberIsNumeric(String numbers) {
    for (char number : numbers.toCharArray()) {
      if (!Character.isDigit(number)) {
        throw new IllegalArgumentException(INVALID_NUMERIC_NUMBER);
      }
    }
  }

  public void validateInputNumbersDuplicated(String numbers) {
    Set<Character> set = new HashSet<>();
    for (char number : numbers.toCharArray()) {
      if (!set.add(number)) {
        throw new IllegalArgumentException(INVALID_DUPLICATED_NUMBER);
      }
    }
  }

  public void validateInputNumberOfRestartAndEnd(String number) {
    int intNumber = Integer.parseInt(number);
    if (intNumber != INPUT_RESTART_NUMBER && intNumber != INPUT_END_NUMBER) {
      throw new IllegalArgumentException(INVALID_RESTART_AND_END_NUMBER);
    }
  }
}
