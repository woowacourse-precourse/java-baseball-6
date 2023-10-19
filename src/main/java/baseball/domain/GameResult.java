package baseball.domain;

public record GameResult(
    int ballCount,
    int strikeCount
) {

  public boolean isClear() {
    return strikeCount == BallNumbers.BALL_COUNT;
  }

  public boolean isNothing() {
    return ballCount + strikeCount == 0;
  }
}
