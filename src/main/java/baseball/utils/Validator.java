package baseball.utils;

import java.util.HashSet;
import java.util.Set;

public class Validator {

  private static final int VALID_INPUT_LENGTH = 3;

  private Validator() {
  }

  public static String validateInput(String input) {
    if (input.length() != VALID_INPUT_LENGTH) {
      return "3자리를 입력해주세요.";
    }

    Set<Character> uniqueNumbers = new HashSet<>();

    for (char ch : input.toCharArray()) {
      if (!Character.isDigit(ch) || ch == '0') {
        return "1 ~ 9 사이의 값을 입력해주세요.";
      }
      if (!uniqueNumbers.add(ch)) {
        return "중복된 숫자는 입력할 수 없습니다.";
      }
    }

    return null;
  }

  public static boolean isValidChoice(String choice) {
    return "1".equals(choice) || "2".equals(choice);
  }
}
