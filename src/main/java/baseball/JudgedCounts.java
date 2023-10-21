package baseball;

public class JudgedCounts {
  private int strike;
  private int ball;
  public JudgedCounts(int strike, int ball) {
      this.strike = strike;
      this.ball = ball;
  }

    public int getStrike() {
      return strike;
    }
    public int getBall() {
      return ball;
    }

  public void setStrike() {
      this.strike +=1 ;
  }
  public void setBall() {
    this.ball +=1 ;
  }
}
