package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

  static int size = 3;

  public static void main(String[] args) {

    System.out.println("숫자 야구 게임을 시작합니다.");

    ComputerNumber computer = new ComputerNumber();
    Input in = new Input();
    Rule rule = new Rule();
    Retry retry = new Retry();

    boolean again = true;

    while (again) {
      List<Integer> com_num = computer.ComputerNumber();

      String result = "";

      while (!result.equals("3스트라이크")) {
        result = rule.ruleResult(com_num, in.Input_num());
        System.out.println(result);

      }

      again = retry.retry();
    }

  }

}


