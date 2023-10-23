package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import net.bytebuddy.implementation.bytecode.Throw;

public class Input {
  public List<Integer> Input_num() {

    System.out.print("숫자를 입력해주세요 : ");
    String input = Console.readLine();
    List<Integer> Input_num = new ArrayList<>();

    for (String number : input.split("")) {
      Input_num.add(Integer.parseInt(number));
    }
    exception_Length(input);

    return Input_num;
  }

  public void exception_Length(String s) {
    if (s.length() != Application.size) {
      throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
    }
    System.out.println();
  }
}

