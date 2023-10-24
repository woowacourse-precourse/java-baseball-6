package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
  private List<Integer> answer;

  /**
   * 서로 다른 3개의 정수를 List<Integer>형의 answer로 저장
   */
  public void makeAnswer() {
    answer = new ArrayList<>();

    while (answer.size() != 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!(answer.contains(randomNumber))) {
        answer.add(randomNumber);
      }
    }
  }

  public Result getResult(List<Integer> input) {
    Result result = new Result();

    for (int i = 0; i < 3; i++) {

      if (answer.contains(input.get(i))) {
        if (answer.get(i) == input.get(i)) {
          result.addStrike();
        } else {
          result.addBall();
        }
      }
    }

    return result;
  }

}