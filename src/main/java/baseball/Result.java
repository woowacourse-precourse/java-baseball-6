package baseball;

public class Result {

  private final int strike;
  private final String message;

  public Result(int strike, String message) {
    this.strike = strike;
    this.message = message;
  }

  public int getStrike() {
    return strike;
  }

  public String getMessage() {
    return message;
  }
}