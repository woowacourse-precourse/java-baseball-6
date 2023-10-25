package baseball.domain;

public class Result {
  private final int balls;
  private final int strikes;

  public Result(int balls, int strikes) {
    this.balls = balls;
    this.strikes = strikes;
  }

  public boolean isGameWon() {
    return strikes == 3;
  }

  @Override
  public String toString() {
    if (balls == 0 && strikes == 0) {
      return "낫싱";
    } else if (strikes == 3) {
      return "3스트라이크";
    } else {
      return balls + "볼 " + strikes + "스트라이크";
    }
  }
}


