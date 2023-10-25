package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;


public class Input {
  public List<Integer> Input_num() {

    System.out.print("숫자를 입력해주세요 : ");
    String input = Console.readLine();
    List<Integer> Input_num = new ArrayList<>();

    try {
      for (String number : input.split("")) {
        Input_num.add(Integer.parseInt(number));
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("문자는 입력할 수 없습니다.");
    }
    exception_Length(input);
    return Input_num;
  }

  public void exception_Length(String s) {
    if (s.length() != Application.size) {
      throw new IllegalArgumentException("숫자가 3개보다 크거나 작습니다.");
    }

    String answer = "";
    for (int i = 0; i < s.length(); i++) {
      if (s.indexOf(s.charAt(i)) == i)
        answer += s.charAt(i);
    }
    if (answer.length() != Application.size) {
      throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
    }
    if (s.contains("0") == true) {
      throw new IllegalArgumentException("1부터 9까지의 숫자만 입력할 수 있습니다.");
    }

  }
}
