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
    validateStartLength(inputStr);

    for (int i = 0; i < INPUT_SIZE; i++) {
      char inputChar = inputStr.charAt(i);
      validateStartNumber(inputChar);

      int inputNumber = Character.getNumericValue(inputChar);
      validateExistsNumber(inputNumber, inputNumbers);

      inputNumbers.add(inputNumber);
    }

    return inputNumbers;
  }

  public int endInput() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    String inputStr = Console.readLine();
    validateExitNumber(inputStr);

    return Integer.parseInt(inputStr);
  }

  private void validateStartLength(String inputStr) {
    if (inputStr.length() != INPUT_SIZE) {
      throw new IllegalArgumentException("3개의 숫자만 입력이 가능합니다.");
    }
  }

  private void validateStartNumber(char inputChar) {
    if (inputChar < '1' || inputChar > '9') {
      throw new IllegalArgumentException("1~9까지의 숫자만 입력이 가능 합니다.");
    }
  }

  private void validateExistsNumber(int inputNumber, List<Integer> inputNumbers) {
    if (inputNumbers.contains(inputNumber)) {
      throw new IllegalArgumentException("서로 다른 숫자만 입력이 가능 합니다.");
    }
  }

  private void validateExitNumber(String inputStr) {
    if (!(inputStr.equals("1") || inputStr.equals("2"))) {
      throw new IllegalArgumentException("1 또는 2만 입력이 가능 합니다.");
    }
  }

}
