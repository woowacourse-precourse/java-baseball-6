package baseball;

import java.util.List;

public class Rule {

  // computer number와 input number 같은 숫자 있는지 비교
  public int Hit(List<Integer> computer, List<Integer> input) {
    int result = 0;

    for (int i = 0; i < Application.size; i++) {
      if (computer.contains(input.get(i))) {
        result++;        
      }
    }
    return result;
  }

  public int countStrike(List<Integer> computer, List<Integer> input) {
    int strike = 0;

    for (int i = 0; i < Application.size; i++) {
      if (computer.get(i) == input.get(i)) {
        strike++;        
      }
    }
    return strike;
  }

  public String ruleResult(List<Integer> computer, List<Integer> input) {
    int total = Hit(computer, input);
    int strike = countStrike(computer, input);
    int ball = total - strike;

    if (total == 0) {
      return "낫싱";
    }
    else if (strike == 0) {
      return ball + "볼";
    }
    else if (ball == 0) {
      return strike + "스트라이크";
    }
    return ball + "볼 " + strike + "스트라이크";

  }

}
