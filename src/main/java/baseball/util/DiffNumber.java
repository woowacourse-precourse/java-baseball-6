package baseball.util;

import java.util.List;

public class DiffNumber {
  public int CompareNumber(List<Integer> computer, List<Integer> player) {
    int result = 0;

    for(int i = 0; i < player.size(); i++) {
      if(computer.contains(player.get(i))) result++;
    }
    return result;
  }

  public int strikeCount(List<Integer> computer, List<Integer> player) {
    int strike = 0;

    for(int i = 0; i < player.size(); i++) {
      if(computer.get(i) == player.get(i)) strike++;
    }
    return strike;
  }

  public String strikeAndBallCount(List<Integer> computer, List<Integer> player) {
    int total = CompareNumber(computer, player);
    int strike = strikeCount(computer, player);
    int ball = total - strike;

    if(total == 0) {
      return "낫싱";
    } else if(strike == 0) {
      return ball + "볼";
    } else if(ball == 0) {
      return strike + "스트라이크";
    } else {
      return ball + "볼 " + strike + "스트라이크";
    }
  }
}