package baseball;

import java.util.List;
import java.util.Objects;

public class BallComparator {
  public int total(List<Integer> computer, List<Integer> user) {
    int result = 0;
    for (int i = 0; i < computer.size(); i++) {
      if (computer.contains(user.get(i))) {
        result += 1;
      }
    }
    return result;
  }

  public int getStrike(List<Integer> computer, List<Integer> user) {
    int result = 0;
    for (int i = 0; i < computer.size(); i++) {
      if (Objects.equals(computer.get(i), user.get(i))) {
        result += 1;
      }
    }

    return result;
  }
}
