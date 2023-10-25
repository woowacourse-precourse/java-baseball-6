package baseball.utils;

import java.util.Set;

public class Convertor {

  /**
   * Converter : String to int array
   *
   * @param inputNumber
   * @return
   */
  public static int[] convertStringToIntArray(String inputNumber) {
    return inputNumber.chars()
        .map(Character::getNumericValue)
        .toArray();
  }

  /**
   * Converter : Integer to int array
   *
   * @param numbers
   * @return
   */
  public static int[] convertIntegerToInt(Set<Integer> numbers) {
    return numbers.stream().mapToInt(Integer::intValue).toArray();
  }
}
