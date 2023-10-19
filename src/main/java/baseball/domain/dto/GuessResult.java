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

  public String renderToString() {
    if (isNothing()) {
      return "낫싱";
    }
    final StringBuilder sb = new StringBuilder();
    if (ballCount > 0) {
      sb.append(String.format("%d볼 ", ballCount));
    }
    if (strikeCount > 0) {
      sb.append(String.format("%d스트라이크", strikeCount));
    }
    return sb.toString();
  }
}
