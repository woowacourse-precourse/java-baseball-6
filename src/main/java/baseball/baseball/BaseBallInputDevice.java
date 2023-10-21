package baseball.baseball;

import static baseball.common.Constant.BALL_AMOUNT;
import static baseball.common.Constant.EXIT_NUMBER_STR;
import static baseball.common.Constant.MAX_BALL_NUMBER_CHAR;
import static baseball.common.Constant.MIN_BALL_NUMBER_CHAR;
import static baseball.common.Constant.RESTART_NUMBER_STR;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseBallInputDevice {

  public List<Integer> startInput() {
    System.out.print("숫자를 입력해주세요 : ");

    List<Integer> inputNumbers = new ArrayList<>();
    String inputStr = Console.readLine();
    validateStartLength(inputStr);

    for (int i = 0; i < BALL_AMOUNT; i++) {
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
    if (inputStr.length() != BALL_AMOUNT) {
      throw new IllegalArgumentException("3개의 숫자만 입력이 가능합니다.");
    }
  }

  private void validateStartNumber(char inputChar) {
    if (inputChar < MIN_BALL_NUMBER_CHAR || inputChar > MAX_BALL_NUMBER_CHAR) {
      throw new IllegalArgumentException("1~9까지의 숫자만 입력이 가능 합니다.");
    }
  }

  private void validateExistsNumber(int inputNumber, List<Integer> inputNumbers) {
    if (inputNumbers.contains(inputNumber)) {
      throw new IllegalArgumentException("서로 다른 숫자만 입력이 가능 합니다.");
    }
  }

  private void validateExitNumber(String inputStr) {
    if (!(inputStr.equals(RESTART_NUMBER_STR) || inputStr.equals(EXIT_NUMBER_STR))) {
      throw new IllegalArgumentException("1 또는 2만 입력이 가능 합니다.");
    }
  }

}
