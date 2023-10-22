package baseball.domain.result;

public class GameResult {

  private static final String BALLS_FORMAT = "%d볼";
  private static final String STRIKES_FORMAT = "%d스트라이크";
  private static final String NOTHING = "낫싱";
  private static final String DELIMITER = " ";

  private final int strikeCount;
  private final int ballCount;

  private GameResult(final int strikeCount, final int ballCount) {
    this.strikeCount = strikeCount;
    this.ballCount = ballCount;
  }

  public static GameResult of(final int strikeCount, final int ballCount) {
    return new GameResult(strikeCount, ballCount);
  }

  @Override
  public String toString() {
    if (strikeCount > 0 && ballCount > 0) {
      return String.format(BALLS_FORMAT + DELIMITER + STRIKES_FORMAT, ballCount, strikeCount);
    }
    if (ballCount > 0) {
      return String.format(BALLS_FORMAT, ballCount);
    }
    if (strikeCount > 0) {
      return String.format(STRIKES_FORMAT, strikeCount);
    }
    return NOTHING;
  }
}
