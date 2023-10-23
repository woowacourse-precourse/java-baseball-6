package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {

  public List<Integer> inputNumbers() {
    System.out.print("숫자를 입력해주세요: ");
    String input = Console.readLine();
    System.out.println(input);
    List<Integer> inputNumbers = new ArrayList<>();
    // 입력받은 문자열을 공백을 기준으로 분할하여 배열로 변환
    String[] numberStrings = input.split("");
    System.out.println(numberStrings[0] + numberStrings[1] + numberStrings[2]);
    // 각 문자열을 정수로 변환하여 numbers 리스트에 추가
    for (String numberString : numberStrings) {
      int number = Integer.parseInt(numberString);
      inputNumbers.add(number);
    }
    return inputNumbers;
  }
}
