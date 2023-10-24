package baseball;

import java.util.List;

public class CheckAnswer {
  BallComparator ballComparator = new BallComparator();

  public String check(List<Integer> computer, List<Integer> user) {
    int strike = ballComparator.getStrike(computer, user);
    int ball = ballComparator.getBall(computer, user);

    if (ball == 0 && strike == 0) {
      return "낫싱";
    } else if (ball == 0) {
      return strike + "스트라이크";
    } else if (strike == 0) {
      return ball + "볼";
    }

    return ball + "볼 " + strike + "스트라이크";  // Note the added space between ball and strike.
  }

}
