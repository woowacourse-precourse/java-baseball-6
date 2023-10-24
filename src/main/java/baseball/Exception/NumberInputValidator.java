package baseball.Exception;

import java.util.List;package baseball;


public class NumberInputValidator {
  /**
   입력값을 유효성 검사합니다.
   @param input 입력값으로 받은 문자열입니다.
   @throws IllegalArgumentException 입력값이 유효하지 않을 경우 발생하는 예외입니다. */
  public static void validateInput(String input) {
    try {
      for (int i = 0; i < input.length(); i++) {
        if (input.charAt(i) - '0' < 1 || input.charAt(i) - '0' > 9) {
          throw new IllegalArgumentException("입력한 숫자가 범위를 초과했습니다.");
        }
      }
    } catch (NumberFormatException exception) {
      throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
    }
  }
}