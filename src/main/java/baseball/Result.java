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
}
