package baseball;

import static baseball.View.displayInputMessage;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

class UserBalls {

  /**
   * Displays Input Message. Returns user input, after checking it is valid.
   *
   * @return the user input
   */
  public static String getUserInputBalls() {
    displayInputMessage();
    String input = Console.readLine();
    checkUserInput(input);
    return input;
  }

  /**
   * Checks if user input is valid. Throws IllegalArgumentException and ends program if input is not
   * valid.
   *
   * @param input the user input
   */
  private static void checkUserInput(String input) throws IllegalArgumentException {
    checkLength(input);
    checkAllNumbers(input);
    checkInValidRange(input);
    checkDifferentDigits(input);
  }

  /**
   * Checks if user input length is 3.
   *
   * @param input the user input
   */
  private static void checkLength(String input) {
    if (input.length() != 3) {
      throw new IllegalArgumentException("[ERROR] 입력된 숫자가 3자리가 아닙니다");
    }
  }

  /**
   * Checks if user input consists of 3 different digits.
   *
   * @param input the user input
   */
  private static void checkDifferentDigits(String input) {
    if (!areDigitsDifferent(input)) {
      throw new IllegalArgumentException("[ERROR] 서로 다른 3자리가 아닙니다");
    }
  }

  /**
   * Checks if user input is in valid range(1~9).
   *
   * @param input the user input
   */
  private static void checkInValidRange(String input) {
    if (containsZero(input)) {
      throw new IllegalArgumentException("[ERROR] 1이상 9이하 숫자가 아닙니다");
    }
  }

  /**
   * Checks if user input consists of all integers.
   *
   * @param input the user input
   */
  private static void checkAllNumbers(String input) {
    if (!areAllNumbers(input)) {
      throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다");
    }
  }

  /**
   * Returns true if all digits are different.
   *
   * @return true if all digits are different
   */
  private static boolean areDigitsDifferent(String input) {
    Set<Character> charSet = new HashSet<>();
    for (char x : input.toCharArray()) {
      charSet.add(x);
    }
    return charSet.size() == input.length();
  }

  /**
   * Returns true if input contains zero.
   *
   * @return true if input contains zero
   */
  private static boolean containsZero(String input) {
    Set<Character> charSet = new HashSet<>();
    for (char x : input.toCharArray()) {
      charSet.add(x);
    }
    return charSet.contains('0');
  }

  /**
   * Returns true input consists of Digits.
   *
   * @return true input consists of Digits
   */
  private static boolean areAllNumbers(String input) {
    return input.chars().allMatch(Character::isDigit);
  }

}
