package baseball;

import static baseball.common.Message.START_MESSAGE;
import static baseball.common.Message.STRIKE_MESSAGE;

import baseball.game.Game;

public class Application {

  public static void main(String[] args) {
    // TODO: 프로그램 구현
    Game game = new Game();

    System.out.println(START_MESSAGE);
    game.playBaseBallGame();
  }
}
