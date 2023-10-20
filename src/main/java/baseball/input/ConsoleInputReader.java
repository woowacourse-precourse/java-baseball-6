package baseball.input;

import camp.nextstep.edu.missionutils.Console;

/**
 * @author 민경수
 * @description console input reader
 * @since 2023.10.20
 **********************************************************************************************************************/
public class ConsoleInputReader implements InputReader{

  @Override
  public Integer readNumber() {
    return stringToInteger(Console.readLine());
  }

  private int stringToInteger(String number) {
    try {
      return Integer.valueOf(number);
    } catch (NumberFormatException nfe) {
      throw new IllegalArgumentException("입력하신 값 '" + number + "'는 숫자로 변환할 수 없습니다.");
    }
  }

}