package baseball.baseball;

import static baseball.common.Constant.BALL_AMOUNT;

public class Result {

  private final int strikeCount;
  private final int ballCount;

  public Result(int strikeCount, int ballCount) {
    this.strikeCount = strikeCount;
    this.ballCount = ballCount;
  }

  public int getStrikeCount() {
    return this.strikeCount;
  }

  public int getBallCount() {
    return this.ballCount;
  }

  public Boolean isAllStrikes() {
    return this.strikeCount == BALL_AMOUNT;
  }

}
