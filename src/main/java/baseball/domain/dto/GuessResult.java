package baseball.domain.dto;

import baseball.domain.ball.BallNumbers;

public record GuessResult(
    int ballCount,
    int strikeCount
) {

  public boolean isThreeStrike() {
    return strikeCount == BallNumbers.BALL_COUNT;
  }

  public boolean isNothing() {
    return ballCount + strikeCount == 0;
  }
}
