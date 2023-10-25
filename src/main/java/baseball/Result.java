package baseball;

public class Result {

  private int Strike = 0;
  private int Ball = 0;

  public Result() {
  }

  public void addStrike() {
    Strike++;
  }

  public void addBall() {
    Ball++;
  }

  public boolean isEnd() {
    return Strike == Constant.SIZE;
  }

  public String getResult() {
    StringBuilder resultBuilder = new StringBuilder();
    if (Ball == 0 && Strike == 0) {
      return "낫싱";
    }
    if (Ball > 0) {
      resultBuilder.append(Ball).append("볼 ");
    }
    if (Strike > 0) {
      resultBuilder.append(Strike).append("스트라이크");
    }
    return resultBuilder.toString().trim();
  }
}
