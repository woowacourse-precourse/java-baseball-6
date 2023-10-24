package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Game {

  private Computer computer;

  public Game() {
    this.computer = new Computer();
  }

  public void start() {
    System.out.println("숫자 야구 게임을 시작합니다.");
    while (true) {
      computer.makeRandomNumber();
      userInput();
      if (!qnRestart()) {
        break;
      }
    }
  }

  // 사용자 숫자 입력
  private boolean userInput() {
    while (true) {
      User user = new User(new ArrayList<>());

      System.out.print("숫자를 입력해주세요 : ");
      String input = Console.readLine();

      user.inputValidation(input);

      // 컴퓨터의 수와 사용자의 수 비교
      computer.compare(user);

      if (user.getStrike() == 3) {
        System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return true;
      }

      user.viewResult();

    }
  }

  private boolean qnRestart() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    int choice = Integer.parseInt(Console.readLine());
    if (choice == 1) {
      computer = new Computer();
    } else if (choice == 2) {
      return false;
    } else {
      throw new IllegalArgumentException("1 또는 2만 입력하세요");
    }

    return true;
  }


}
