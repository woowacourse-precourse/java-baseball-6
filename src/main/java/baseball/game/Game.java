package baseball.game;

import static baseball.common.Constant.EXIT_NUMBER;

import baseball.baseball.BaseBall;
import baseball.baseball.BaseBallInputDevice;
import java.util.List;

public class Game {

  private final BaseBallInputDevice inputDevice;

  public Game() {
    this.inputDevice = new BaseBallInputDevice();
  }

  public void playBaseBallGame() {
    BaseBall baseBall = new BaseBall();

    startBaseBallGame(baseBall);

    if (isEndPlay()) {
      return;
    }

    playBaseBallGame();
  }

  private void startBaseBallGame(BaseBall baseBall) {
    List<Integer> startInput = inputDevice.startInput();

    int strikeCount = baseBall.getStrikeCount(startInput);

    if (baseBall.isSucceed(strikeCount)) {
      return;
    }

    startBaseBallGame(baseBall);
  }

  private Boolean isEndPlay() {
    int endInput = inputDevice.endInput();
    return endInput == EXIT_NUMBER;
  }

}
