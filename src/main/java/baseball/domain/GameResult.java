package baseball.domain;

public final class GameResult {

  private final int ballCount;
  private final int strikeCount;

  public GameResult(
      final int ballCount,
      final int strikeCount
  ) {
    this.ballCount = ballCount;
    this.strikeCount = strikeCount;
  }

  public int getBallCount() {
    return ballCount;
  }

  public int getStrikeCount() {
    return strikeCount;
  }
}
