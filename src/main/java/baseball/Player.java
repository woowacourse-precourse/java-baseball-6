package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class Player {
  /** 사용자로부터 숫자를 입력받고 해당 입력값을 정수 리스트로 변환 */
  public List<Integer> inputNumbers() {
    String input = Console.readLine();
    System.out.println(input);
    List<Integer> inputNumbers = parseInput(input);
    return inputNumbers;
  }

  /** 문자열 형태의 입력값을 정수 리스트로 변환*/
  private List<Integer> parseInput(String input) {
    List<Integer> inputNumbers = new ArrayList<>();
    String[] numberStrings = input.split("");
    for (String numberString : numberStrings) {
      int number = Integer.parseInt(numberString);
      inputNumbers.add(number);
    }
    return inputNumbers;
  }
}