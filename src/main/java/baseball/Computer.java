package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
  private List<Integer> computer = new ArrayList<>();

  public Computer() {
    while (computer.size() < 3) {
      int randomNum = Randoms.pickNumberInRange(1, 9);

      if (!computer.contains(randomNum)) {
        computer.add(randomNum);
      }
    }
  }

  public boolean compare(List<Integer> numsToCompare) {

    int strike = 0;
    int ball = 0;

    for (int i = 0; i < 3; i++) {
      if (numsToCompare.get(i) == computer.get(i)) {
        strike++;
      } else if (computer.contains(numsToCompare.get(i))) {
        ball++;
      }
    }

    printCompareResult(ball, strike);

    return strike == 3;
  }

  private void printCompareResult(int ball, int strike) {

    String result = "";

    if (ball > 0) {
      result = ball + "볼";
    }

    if (strike > 0) {

      if (ball > 0) {
        result = result + " ";
      }

      result = result + strike + "스트라이크";
    } else if (ball == 0 && strike == 0) {
      result = "낫싱";
    }

    if (strike == 3) {
      result = result + "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    System.out.println(result);
  }

  public List<Integer> getComputer() {
    return computer;
  }

}
