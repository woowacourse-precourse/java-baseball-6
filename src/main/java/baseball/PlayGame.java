package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class PlayGame {

  private final Player player;
  private final BaseballGame game;

  public PlayGame() {
    this.player = new Player();
    this.game = new BaseballGame();
  }

  public void startGame() {
    System.out.println("숫자 야구 게임을 시작합니다.");

    do {
      String result = "";
      while (!result.equals("3스트라이크")) {
        List<Integer> playerInput = player.getInput();
        result = game.playRound(playerInput);
        System.out.println(result);
      }

      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    } while (askToPlayAgain());
  }


  private boolean askToPlayAgain() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    return "1".equals(Console.readLine());
  }
}
