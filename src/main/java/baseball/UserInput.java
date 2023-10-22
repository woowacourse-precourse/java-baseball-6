package baseball;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

class UserInput {

  public static String userInput(Scanner sc) {
    displayInputMessage();
    String input = sc.next();
    checkUserInput(input);
    return input;
  }

  private static void displayInputMessage() {
    System.out.println("숫자를 입력해주세요 : ");
  }

  private static void checkUserInput(String input) throws IllegalArgumentException {
    checkLength(input);
    checkAllNumbers(input);
    checkContainsZero(input);
    checkDifferentDigits(input);
  }

  private static void checkLength(String input) {
    if (input.length() != 3) {
      throw new IllegalArgumentException("[ERROR] 입력된 숫자가 3자리가 아닙니다");
    }
  }

  private static void checkDifferentDigits(String input) {
    if (!areDigitsDifferent(input)) {
      throw new IllegalArgumentException("[ERROR] 서로 다른 3자리가 아닙니다");
    }
  }

  private static void checkContainsZero(String input) {
    if (containsZero(input)) {
      throw new IllegalArgumentException("[ERROR] 1이상 9이하 숫자가 아닙니다");
    }
  }

  private static void checkAllNumbers(String input) {
    if (!areAllNumbers(input)) {
      throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다");
    }
  }

  private static boolean areDigitsDifferent(String input) {
    Set<Character> charSet = new HashSet<>();
    for (char x : input.toCharArray()) {
      charSet.add(x);
    }
    return charSet.size() == input.length();
  }

  private static boolean containsZero(String input) {
    Set<Character> charSet = new HashSet<>();
    for (char x : input.toCharArray()) {
      charSet.add(x);
    }
    return charSet.contains('0');
  }

  private static boolean areAllNumbers(String input) {
    return input.chars().allMatch(Character::isDigit);
  }

}
