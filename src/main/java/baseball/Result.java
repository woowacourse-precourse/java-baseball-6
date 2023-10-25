package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Result {

  private int Strike = 0;
  private int Ball = 0;

  public Result() {
  }

  public boolean isEnd() {
    return Strike == Constant.SIZE;
  }

  public void reset() {
    Strike = 0;
    Ball = 0;
  }

  public void calculateResult(List<Integer> ComputerNum, List<Integer> playerNum) {
    Set<Integer> computerNumSet = new HashSet<>(ComputerNum);

    for (int i = 0; i < Constant.SIZE; i++) {
      if (Objects.equals(playerNum.get(i), ComputerNum.get(i))) {
        Strike++;
      } else if (computerNumSet.contains(playerNum.get(i))) {
        Ball++;
      }
    }
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
