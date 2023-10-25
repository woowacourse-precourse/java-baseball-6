package baseball;

public class ScoreDTO {
  private int ball;
  private int strike;

  public ScoreDTO() {
    this.ball = 0;
    this.strike = 0;
  }

  public int getBall() {
    return ball;
  }

  public void setBall(int ball) {
    this.ball = ball;
  }

  public int getStrike() {
    return strike;
  }

  public void setStrike(int strike) {
    this.strike = strike;
  }

  public void addBall() {  // ball 개수 추가
    ball++;
  }

  public void addStrike() {  // strike 개수 추가
    strike++;
  }
}
