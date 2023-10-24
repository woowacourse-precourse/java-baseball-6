package baseball.play.restart;

public class GameRestartCommand {
  private final String restartOrEndMessage;

  private GameRestartCommand(String restartOrEndMessage) {
    this.restartOrEndMessage = restartOrEndMessage;
  }

  public static GameRestartCommand of(String restartOrEndMessage) {
    return new GameRestartCommand(restartOrEndMessage);
  }

  public String getRestartOrEndMessage() {
    return restartOrEndMessage;
  }
}
