package baseball.game;

import static baseball.common.Constant.EXIT_NUMBER;

import baseball.baseball.BaseBall;
import baseball.baseball.BaseBallInputDevice;
import baseball.baseball.BaseBallOutputDevice;
import baseball.baseball.Result;
import java.util.List;

public class Game {

  private final BaseBallInputDevice inputDevice;
  private final BaseBallOutputDevice outputDevice;

  public Game() {
    this.inputDevice = new BaseBallInputDevice();
    this.outputDevice = new BaseBallOutputDevice();
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
    outputDevice.printStartInputMessage();
    List<Integer> startInput = inputDevice.startInput();
    Result result = baseBall.getPlayResult(startInput);
    outputDevice.printResultMessage(result);

    if (result.isAllStrikes()) {
      outputDevice.printSuccessMessage();
      return;
    }

    startBaseBallGame(baseBall);
  }

  private Boolean isEndPlay() {
    outputDevice.printEndInputMessage();
    int endInput = inputDevice.endInput();
    return endInput == EXIT_NUMBER;
  }

}
