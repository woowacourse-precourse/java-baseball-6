package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class GameSystem {
  private final Player player;
  private final Result result;

  public GameSystem() {
    player = new Player();
    result = new Result();
  }

  public void runGame() {
    System.out.println("숫자 야구 게임을 시작합니다.");
    playGame();
  }

  public void playGame() {
    Computer computer = new Computer();

    while (true) {
      //객체 재사용을 위한 초기화
      player.reset();
      result.reset();

      player.setPlayerNum();

      result.calculateResult(computer.getComputerNum(), player.getPlayerNum());
      System.out.println(result.getResult());

      if (result.isEnd()) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        restartGame();
        break;
      }
    }
  }

  public void restartGame() {
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
