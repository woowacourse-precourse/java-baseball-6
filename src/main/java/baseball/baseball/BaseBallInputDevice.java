package baseball.baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseBallInputDevice {

  private static final int INPUT_SIZE = 3;

  public List<Integer> input() {
    List<Integer> inputNumbers = new ArrayList<>();

    String inputStr = Console.readLine();
    validateLength(inputStr);

    for (int i = 0; i < INPUT_SIZE; i++) {
      char inputChar = inputStr.charAt(i);
      validateNumeric(inputChar);

      int inputNumber = Character.getNumericValue(inputChar);
      validateExistsNumber(inputNumber, inputNumbers);

      inputNumbers.add(inputNumber);
    }

    return inputNumbers;
  }

  private void validateLength(String inputStr){
    if (inputStr.length() > INPUT_SIZE) {
      throw new IllegalArgumentException("3개의 숫자만 입력이 가능합니다.");
    }
  }

  private void validateNumeric(char inputChar) {
    if (inputChar < '0' || inputChar > '9') {
      throw new IllegalArgumentException("숫자만 입력이 가능 합니다.");
    }
  }

  private void validateExistsNumber(int inputNumber, List<Integer> inputNumbers) {
    if (inputNumbers.contains(inputNumber)) {
      throw new IllegalArgumentException("서로 다른 숫자만 입력이 가능 합니다.");
    }
  }

}
