package baseball;

import baseball.game.BaseballGameApplication;
import baseball.view.ApplicationConsole;

public class Application {

  public static void main(String[] args) {

    new BaseballGameApplication(new ApplicationConsole()).run();
  }
}
