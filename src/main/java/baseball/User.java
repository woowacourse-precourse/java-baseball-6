package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class User {
  private List<Integer> numsToCompare;

  public void getUserGuessNum() {

    System.out.print("숫자를 입력해주세요 : ");

    String userNumber = Console.readLine();


    if (!userNumber.matches("[0-9]{3,3}")) {
      throw new IllegalArgumentException("UNVALID_INPUT");
    } ;

    numsToCompare = Arrays.stream(userNumber.split("")).map(Integer::parseInt).toList();
  }

  public boolean getUserContinue() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    String input = Console.readLine();

    
    if (! (input.equals("1") || input.equals("2"))) {
      throw new IllegalArgumentException("UNVALID_INPUT");
    }

    int progressMenu = Integer.parseInt(input);

    return progressMenu == 1;
  }

  public List<Integer> getNumsToCompare() {
    return numsToCompare;
  }

}
