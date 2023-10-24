package baseball;

/**
 * 결과에 필요한 strrike와 ball 값을 저장
 */
public class Result {

  private int strike;
  private int ball;

  public Result() {
    this.strike = 0;
    this.ball = 0;
  }

  public void addStrike() {
    this.strike++;
  }

  public void addBall() {
    this.ball++;
  }

  public int getStrike() {
    return strike;
  }

  public int getBall() {
    return ball;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    if (strike + ball == 0) {
      return "낫싱";
    } else if (ball != 0) {
      result.append(ball + "볼");
    } else if (strike != 0) {
      if (!result.isEmpty()) {
        result.append(" ");
      }
      result.append(strike + "스트라이크");
    }

    return result.toString();
  }
}
