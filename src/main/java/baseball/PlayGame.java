package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class PlayGame {

  private final Player player;


  public PlayGame() {
    this.player = new Player();
  }

  public void startGame() {
    System.out.println("숫자 야구 게임을 시작합니다.");

    boolean playAgain;
    do {
      String result = "";
      BaseballGame game = new BaseballGame();

      while (!result.equals("3스트라이크")) {
        List<Integer> playerInput = player.getInput();
        if (playerInput == null) {
          return;
        }
        result = game.playRound(playerInput);
        System.out.println(result);
      }

      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
      playAgain = askToPlayAgain();
    } while (playAgain);
  }


  private boolean askToPlayAgain() {
    while (true) {
      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
      String input = Console.readLine();

      if ("1".equals(input)) {
        return true;
      } else if ("2".equals(input)) {
        return false;
      }

      System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
    }
  }
}
