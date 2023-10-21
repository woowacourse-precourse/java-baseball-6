package baseball.baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseBallInputDevice {

  private static final int INPUT_SIZE = 3;

  public List<Integer> startInput() {
    System.out.print("숫자를 입력해주세요 : ");

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

  public int endInput() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    String inputStr = Console.readLine();
    int inputNumber = Integer.parseInt(inputStr);
    validateEndNumber(inputNumber);

    return inputNumber;
  }

  private void validateLength(String inputStr) {
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

  private void validateEndNumber(int inputNumber) {
    if (inputNumber != 1 && inputNumber != 2) {
      throw new IllegalArgumentException("1 또는 2만 입력이 가능합니다.");
    }
  }

}
