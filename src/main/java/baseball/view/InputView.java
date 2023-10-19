package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public final class InputView {

  private int executionCount = 0;

  public List<Integer> inputBallNumbers() {
    if (executionCount++ == 0) {
      System.out.println("숫자 야구 게임을 시작합니다.");
    }
    System.out.print("숫자를 입력해주세요 : ");

    return Arrays.stream(readLine().split(""))
        .map(Integer::parseInt)
        .toList();
  }

  private String readLine() {
    return Console.readLine().trim();
  }
}
