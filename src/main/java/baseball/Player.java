package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class Player {
  /**
   * 사용자로부터 입력을 받아 정수 리스트로 반환하는 메소드입니다.
   * @return {List<Integer>} 입력된 정수 리스트
   */
  public List<Integer> inputNumbers() {
    String input = Console.readLine();
    System.out.println(input);
    return parseInput(input);
  }

  /**
   * 사용자의 입력 문자열을 파싱하여 각 숫자를 Integer로 변환하고, 이 숫자들을 리스트로 반환하는 메소드.
   *
   * @param input 사용자로부터 입력받은 문자열.
   * @return 입력 문자열에서 파싱된 숫자를 담은 리스트.
   */
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