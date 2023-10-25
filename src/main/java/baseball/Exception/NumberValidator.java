package baseball.Exception;

import java.util.List;
import java.util.Arrays;

public class NumberValidator {

  private static final int MAX_NUMBER = 9;
  private static final int MIN_NUMBER = 1;
  private static final int NUMBER_LENGTH = 3;
  private static final int RESTART_NUMBER = 1;
  private static final int FINISH_NUMBER = 2;


  /**
   * 숫자 리스트의 길이
   * <p>
   * /** 숫자 리스트의 길이를 검사하는 메소드.
   *
   * @param numbers 정수를 담은 리스트
   */
  public static void validateLength(List<Integer> numbers) {
    if (numbers.size() != NUMBER_LENGTH) {
      throw new IllegalArgumentException("숫자는 3자리여야 합니다.");
    }
  }

  /**
   * 숫자 리스트의 범위를 검사하는 메소드.
   *
   * @param numbers 정수를 담은 리스트
   */
  public static void validateRange(List<Integer> numbers) {
    for (int number : numbers) {
      if (number < MIN_NUMBER || number > MAX_NUMBER) {
        throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해야 합니다.");
      }
    }
  }

  /**
   * 입력받은 숫자가 RESTART_NUMBER 또는 FINISH_NUMBER인지 확인하는 메소드.
   *
   * @param number - 확인할 숫자
   * @throws IllegalArgumentException 입력한 숫자가 RESTART_NUMBER 또는 FINISH_NUMBER가 아닐 경우 발생합니다.
   */
  public static void checkResetNumber(int number) {
    if (number != RESTART_NUMBER && number != FINISH_NUMBER) {
      throw new IllegalArgumentException("숫자 1 또는 2를 입력해주세요.");
    }
  }
}