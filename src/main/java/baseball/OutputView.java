package baseball;

public class OutputView {

  public void printResult(int strike, int ball) {
    if ((strike == 0) && (ball == 0)) {
      System.out.println("낫싱");
    } else if (strike == 0) {
      System.out.println(ball + "볼");
    } else if (ball == 0) {
      System.out.println(strike + "스트라이크");
    } else {
      System.out.println(ball + "볼 " + strike + "스트라이크");
    }
  }
}
