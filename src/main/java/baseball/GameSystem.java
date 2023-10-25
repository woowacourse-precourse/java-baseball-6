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
    Computer computer = new Computer();

    while (true) {
      Player player = new Player();
      Result result = new Result();

      result.calculateResult(computer.getComputerNum(), player.getPlayerNum());
      System.out.println(result.getResult());

      if (result.isEnd()) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        reStart();
        break;
      }
    }
  }

  public void reStart() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    int choice = Integer.parseInt(readLine());
    switch (choice) {
      case Constant.RESTART:
        playGame();
        break;
      case Constant.ENDGAME:
        break;
      default:
        throw new IllegalArgumentException("1이나 2가 아닌 잘못된 입력이 들어왔습니다.");
    }
  }
}
