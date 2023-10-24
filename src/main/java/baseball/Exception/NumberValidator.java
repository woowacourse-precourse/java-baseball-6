package baseball.Exception;

import java.util.List;

public class NumberValidator {

  private static final int MAX_NUMBER = 9;
  private static final int MIN_NUMBER = 1;
  private static final int NUMBER_LENGTH = 3;

  /**
   * 숫자의 유효성을 검사하는 메소드.
   *
   * @param numbers 숫자를 담은 리스트
   */
  public static void validate(List<Integer> numbers) {
    if (numbers.size() != NUMBER_LENGTH) {
      throw new IllegalArgumentException("숫자는 3자리여야 합니다.");
    }
    for (int number : numbers) {
      if (number < MIN_NUMBER || number > MAX_NUMBER) {
        throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해야 합니다.");
      }
    }
  }
}