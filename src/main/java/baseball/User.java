package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class User {
  private List<Integer> numsToCompare;

  public void getUserGuessNum() {

    System.out.print("숫자를 입력해주세요 : ");

    String userNumber = Console.readLine();

    if (!userNumber.matches("[0-9]+")) {
      throw new IllegalArgumentException("게임 종료");
    } ;

    if (userNumber.length() != 3) {
      throw new IllegalArgumentException("게임 종료");
    }

    numsToCompare = Arrays.stream(userNumber.split("")).map(Integer::parseInt).toList();
  }

  public boolean getUserContinue() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    int input = Integer.parseInt(Console.readLine());

    if (input != 1 && input != 2) {
      throw new IllegalArgumentException("게임 종료");
    }

    return input == 1;
  }

  public List<Integer> getNumsToCompare() {
    return numsToCompare;
  }

}
