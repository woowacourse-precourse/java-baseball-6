package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class GameSystem {

  public GameSystem() {
    System.out.println("숫자 야구 게임을 시작합니다.");
    playGame();
  }

  public void playGame() {
    //컴퓨터의 값을 랜덤값으로 초기화한다.
    Computer computer = new Computer();

    while (true) {
      //사용자의 수를 세팅한다.
      Player player = null;
      try {
        player = new Player();
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage() + " 게임을 종료합니다.");
        break;
      }

      //컴퓨터와 숫자를 비교 후 출력한다.
      String result = check(computer.getComputerNum(), player.getPlayerNum());
      System.out.println(result);

      if (result.equals("3스트라이크")) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        reStart();
        break;
      }
    }
  }

  public void reStart() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    try {
      int choice = Integer.parseInt(readLine());
      switch (choice) {
        case 1:
          playGame();
          break;
        case 2:
          break;
        default:
          throw new IllegalArgumentException("잘못된 입력이 들어왔습니다.");
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("게임을 종료합니다.", e);
    }
  }

  public String check(List<Integer> ComputerNum, List<Integer> playerNum) {
    int ball = 0;
    int strike = 0;
    Set<Integer> computerNumSet = new HashSet<>(ComputerNum);

    for (int i = 0; i < 3; i++) {
      if (Objects.equals(playerNum.get(i), ComputerNum.get(i))) {
        strike++;
      } else if (computerNumSet.contains(playerNum.get(i))) {
        ball++;
      }
    }

    StringBuilder resultBuilder = new StringBuilder();
    if (ball == 0 && strike == 0) {
      return "낫싱";
    }
    if (ball > 0) {
      resultBuilder.append(ball).append("볼 ");
    }
    if (strike > 0) {
      resultBuilder.append(strike).append("스트라이크");
    }
    return resultBuilder.toString().trim();
  }
}