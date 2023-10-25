package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class GameSystem {
  private final static int NUMBER = 3;

  public GameSystem() {
    System.out.println("숫자 야구 게임을 시작합니다.");
    playGame();
  }

  public void playGame() {
    //컴퓨터의 값을 랜덤값으로 초기화한다.
    Computer computer = new Computer();

    while (true) {
      //사용자의 수를 세팅한다.
      Player player = new Player();

      //컴퓨터와 숫자를 비교 후 출력한다.
      String result = check(computer.getComputerNum(), player.getPlayerNum());
      System.out.println(result);

//      if (result.equals() {
//        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//        reStart();
//        break;
////      }
    }
  }


  public String check(List<Integer> ComputerNum, List<Integer> playerNum) {
    Result result = new Result();
    Set<Integer> computerNumSet = new HashSet<>(ComputerNum);

    for (int i = 0; i < NUMBER; i++) {
      if (Objects.equals(playerNum.get(i), ComputerNum.get(i))) {
        result.addStrike();
      } else if (computerNumSet.contains(playerNum.get(i))) {
        result.addBall();
      }
    }
    return result.getResult();
  }
}
