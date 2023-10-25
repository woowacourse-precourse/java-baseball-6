package baseball;

import java.util.Arrays;
import java.util.List;

/**
 * 랜덤 숫자와 사용자 숫자를 비교
 */
public class BaseballGame {

  public List<Integer> evaluate(List<Integer> computer, List<Integer> player) {
    int strike = 0;
    int ball = 0;
    for (int i = 0; i < 3; i++) {
      if (player.get(i).equals(computer.get(i))) {
        strike++;
      } else if (computer.contains(player.get(i))) {
        ball++;
      }
    }
    return Arrays.asList(strike, ball);
  }
}
